package ro.ase.acs.models;

import java.util.Arrays;


public class Meeting {
    private String name;
    private int startTime;
    private int endTime;
    private Priority priority;
    private String[] participants = null;

    public Meeting() {
        this.name = "";
        this.startTime = 0;
        this.endTime = 0;
        this.priority = Priority.low;
    }

    public Meeting(String name, int startTime, int duration) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.priority = Priority.low;
    }


    public String[] getParticipants() {

        if (participants != null) {
            return Arrays.copyOf(participants, participants.length);
        }
        return null;
    }

    public void setParticipants(String[] participants) {
        if (participants != null) {
            this.participants = new String[participants.length];
            System.arraycopy(participants, 0, this.participants, 0, participants.length);
        } else {
            this.participants = null;
        }
    }

    public boolean checkParticipant(String name) {

        if (participants != null) {
            for (String p : participants) {
                if (p.equals(name)) return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void concatenate(Meeting m) {

        if (m == null) {
            return;
        }

        if (m.participants != null) {
            for (String p : m.participants) {
                if (p == null) {
                    continue;
                }

                if (!checkParticipant(p)) {
                    if (this.participants == null) {
                        this.participants = new String[]{p};
                    } else {
                        String[] newParticipants = new String[this.participants.length + 1];
                        System.arraycopy(this.participants, 0, newParticipants, 0, this.participants.length);
                        newParticipants[this.participants.length] = p;
                        this.participants = newParticipants;
                    }
                }
            }
        }
        this.name = this.name + "/" + m.name;

        this.startTime = Math.min(this.startTime, m.startTime);

        this.endTime = Math.max(this.endTime, m.endTime);

        // priorit. in Enum  :LOW=0, MEDIUM=1 si HIGH=2
        if (m.priority != null && (this.priority == null || m.priority.ordinal() > this.priority.ordinal())) {
            this.priority = m.priority;
        }
    }

    @Override
    public Object clone() {
        Meeting copy = new Meeting();
        copy.name = this.name;
        copy.startTime = this.startTime;
        copy.endTime = this.endTime;
        copy.priority = this.priority;
        if (this.participants != null) {
            copy.participants = this.participants.clone();
        } else {
            copy.participants = null;
        }
        return copy;
    }
}
