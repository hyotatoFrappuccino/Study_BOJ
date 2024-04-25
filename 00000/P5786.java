import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P5786 {
    static Map<Integer, SpamPeople> peopleMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            // input
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            peopleMap = new TreeMap<>();
            List<SpamMail> spamMailList = new ArrayList<>();

            // 사람 설정
            for (int i = 1; i <= N; i++) {
                SpamPeople p = new SpamPeople();
                peopleMap.put(i, p);
            }

            // 친구 입력
            for (SpamPeople p : peopleMap.values()) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int friendNum = Integer.parseInt(st.nextToken());
                    if (friendNum == 0) break;
                    p.addFriends(peopleMap.get(friendNum));
                }
            }

            // 메시지 입력
            while (true) {
                st = new StringTokenizer(br.readLine());
                int sender = Integer.parseInt(st.nextToken());
                if (sender == 0) break;
                int T1 = Integer.parseInt(st.nextToken());
                int T2 = Integer.parseInt(st.nextToken());
                String A1 = st.nextToken();
                String A2 = st.nextToken();
                String A3 = st.nextToken();
                SpamMail spamMail = new SpamMail(sender, T1, T2, A1, A2, A3);
                spamMailList.add(spamMail);
            }

            // 이름 입력
            for (SpamPeople people : peopleMap.values()) {
                people.setName(br.readLine());
            }

            for (SpamMail msg : spamMailList) {
                int sender = msg.getSender();
                SpamPeople spamPeople = peopleMap.get(sender);
                List<SpamPeople> friends = spamPeople.getFriends();
                for (SpamPeople friend : friends) {
                    friend.sendSpamMsg(msg);
                }
                spamPeople.sendSpamMsg(msg);
                for (SpamPeople value : peopleMap.values()) {
                    if (!value.getAttributes().contains(msg.getA1()) &&
                        !value.getAttributes().contains(msg.getA2()) &&
                        !value.getAttributes().contains(msg.getA3()))
                        value.addAttribute(msg.getA1());
                }
            }

            for (SpamPeople value : peopleMap.values()) {
                bw.append(value.getName()).append(": ").append(value.getAttributes()).append("\n");
            }
        }
        // output
        bw.flush();

        br.close();
        bw.close();
    }


    static class SpamPeople {
        private String name;
        private final List<SpamPeople> friends;
        private final List<String> attributes;
        private final List<SpamMail> sentSpamMail;

        public SpamPeople() {
            friends = new ArrayList<>();
            attributes = new ArrayList<>();
            sentSpamMail = new ArrayList<>();
        }

        public void sendSpamMsg(SpamMail msg) {
            if (!isSentSpamMsg(msg)) {
                int count = getFriends().size();
                this.addSentSpamMsg(msg);
                for (SpamPeople friend : friends) {
                    friend.sendSpamMsg(msg);
                }
                if (count < msg.getT1())
                    this.addAttribute(msg.getA1());
                else if (count < msg.getT2())
                    this.addAttribute(msg.getA2());
                else
                    this.addAttribute(msg.getA3());
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SpamPeople> getFriends() {
            return friends;
        }

        public void addFriends(SpamPeople p) {
            this.friends.add(p);
        }

        public void addAttribute(String attribute) {
            this.attributes.add(attribute);
        }

        public String getAttributes() {
            StringBuilder sb = new StringBuilder();
            for (String attribute : attributes) {
                sb.append(attribute).append(" ");
            }
            return sb.toString();
        }

        public void addSentSpamMsg(SpamMail spamMail) {
            this.sentSpamMail.add(spamMail);
        }

        public boolean isSentSpamMsg(SpamMail spamMail) {
            return sentSpamMail.contains(spamMail);
        }

        @Override
        public String toString() {
            return "SpamPeople{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class SpamMail {
        private final int sender;
        private final int T1;
        private final int T2;
        private final String A1;
        private final String A2;
        private final String A3;

        public SpamMail(int sender, int t1, int t2, String a1, String a2, String a3) {
            this.sender = sender;
            T1 = t1;
            T2 = t2;
            A1 = a1;
            A2 = a2;
            A3 = a3;
        }

        public int getSender() {
            return sender;
        }

        public int getT1() {
            return T1;
        }

        public int getT2() {
            return T2;
        }

        public String getA1() {
            return A1;
        }

        public String getA2() {
            return A2;
        }

        public String getA3() {
            return A3;
        }
    }
}
