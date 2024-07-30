/**
 * @author divyesh.shah
 */

import java.util.*;

/*
Given N rooms and a meeting list, return the number of the room that held the most meetings.
- Rooms are numbered from 0 to N - 1.
- A meeting in the list is given as a pair of [start_time, end_time) : All the values of start_time are integers and unique.
- The unused room with the lowest number will be assigned to each meeting.

Ex 1>
   Input: N = 2   meetings = [[0, 17], [1, 5], [5, 7]]

1     0: [0, 17]
2     1: [5, 7]

   Output: 1

   Explanation:
   Time 0: Room 0 is assigned to the first meeting.
   Time 1: Room 1 is assigned to the second meeting.
   Time 5: Room 1 is assigned to the third meeting because room 0 is unavailable.

   Room 0 is assigned once, and room 2 is assigned twice. So the output is 1.

Ex 2>
    Input: N = 2 , meetings = [[0,6],[1,5],[7,8]]
    Output: 0

u
2   0: [7, 8]
1   1:

Ex 3>
   Input: N=4  meetings = [[0,12],[1,5],[2,7],[3,4],[4,5]]
   Output: 3

Ex 4>
   Input: N=2 meetings = [[0,1],[1,2],[2,20],[3,4],[4,5],[5,8],[9,13]]
   Output: 1

*/

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3

class MeetingRooms {
    public static void main (String[] args) {
        System.out.println("Hello Java");
        int N1 = 2;
        int [][] meetings1 = {{0, 17}, {1, 5}, {5, 7}};

        int N2 = 4;
        int [][] meetings2 = {{0,12},{1,5},{2,7},{3,4},{4,5}};

        int N = 2;
        int [][] meetings = {{0, 6}, {1, 5}, {7, 8}};

        System.out.println("Max Rooms " + findMaxRooms(N, meetings));

//        System.out.println("Max Rooms " + findMaxMeetingRooms(N, meetings));
//        System.out.println("Max Rooms " + findMaxMeetingRooms(N1, meetings1));
//        System.out.println("Max Rooms " + findMaxMeetingRooms(N2, meetings2));
//        System.out.println("Max Rooms " + findMaxRooms(N2, meetings2));
//        System.out.println("No Rooms " + findMaxMeeting(N, meetings));
    }

    public static int findMaxRooms(int num, int[][] meetings) {

        if(num == 0 || meetings == null)
            throw new IllegalArgumentException("Pass valid input");

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        Stack<Integer> room = new Stack<>();

        int maxRooms = 0;

        for(int index = 0; index < meetings.length; index++) {
            int startTime = meetings[index][0];
            int endTime = meetings[index][1];
            //room.add(maxRooms);

            if(!roomEndTimes.isEmpty() && roomEndTimes.peek() <= startTime) {
                roomEndTimes.poll();
                room.add(maxRooms--);
            }
            else {
                //maxRooms++;
                room.add(maxRooms++);
            }

            roomEndTimes.offer(endTime);
        }
        return room.peek();

    }

    public static int findMaxMeetingRooms(int num, int[][] meetings) {

        if(num == 0 || meetings == null)
            throw new IllegalArgumentException("Pass valid input");

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        int[] roomCounter = new int[num];
        for(int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            boolean roomFound = false;

            for(int index = 0; index < num; index++) {

                if(roomCounter[index] <= startTime) {
                    roomCounter[index] = endTime;
                    roomFound = true;
                    break;
                }
            }

            if(!roomFound) {
                roomCounter[num - 1] = endTime;
            }
        }

        int maxMeetings = 0;
        int maxRoom = 0;

        for(int index = 0 ; index < num; index++) {
            if(roomCounter[index] != 0) {
                int meetingCount = index + 1;

                if(meetingCount > maxMeetings) {
                    maxMeetings = meetingCount;
                    maxRoom = index;
                }
            }
        }
        return maxRoom;
    }

    public static int findMaxMeeting(int num, int[][] meetings) {
        if(num == 0 || meetings == null)
            throw new IllegalArgumentException("Pass valid input");

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        for(int i=0; i<meetings.length; i++) {
            for(int j=0; j < meetings[i].length; j++)
                System.out.println(meetings[i][j]);
        }
        return 1;
    }
}




