from typing import List
import heapq

def find_max_rooms(num: int, meetings: List[List[int]]) -> int:
    """
    Find the room with the maximum number of meetings.

    Args:
    num (int): Number of rooms.
    meetings (List[List[int]]): List of meetings with [start_time, end_time).

    Returns:
    int: The room number that held the most meetings.
    """
    if num <= 0 or meetings is None:
        raise ValueError("Pass valid input")

    # Sort meetings by start time
    meetings.sort(key=lambda x: x[0])

    # Priority queue to track end times of meetings
    room_end_times = []
    # Stack to track room assignments
    room = []

    max_rooms = 0

    for start_time, end_time in meetings:
        # Free up rooms that have ended before the current meeting starts
        while room_end_times and room_end_times[0] <= start_time:
            heapq.heappop(room_end_times)
            room.pop()

        if len(room) < num:
            room.append(max_rooms)
            max_rooms += 1

        heapq.heappush(room_end_times, end_time)

    return room[-1] if room else -1

def find_max_meeting_rooms(num: int, meetings: List[List[int]]) -> int:
    """
    Find the room with the most meetings by tracking meeting room end times.

    Args:
    num (int): Number of rooms.
    meetings (List[List[int]]): List of meetings with [start_time, end_time).

    Returns:
    int: The room number that held the most meetings.
    """
    if num <= 0 or meetings is None:
        raise ValueError("Pass valid input")

    # Sort meetings by start time
    meetings.sort(key=lambda x: x[0])
    room_counter = [0] * num

    for start_time, end_time in meetings:
        room_found = False

        for index in range(num):
            if room_counter[index] <= start_time:
                room_counter[index] = end_time
                room_found = True
                break

        if not room_found:
            room_counter[num - 1] = end_time

    max_meetings = 0
    max_room = 0

    for index in range(num):
        if room_counter[index] != 0:
            meeting_count = index + 1
            if meeting_count > max_meetings:
                max_meetings = meeting_count
                max_room = index

    return max_room

def find_max_meeting(num: int, meetings: List[List[int]]) -> int:
    """
    Print the meetings and return 1 for demonstration purposes.

    Args:
    num (int): Number of rooms.
    meetings (List[List[int]]): List of meetings with [start_time, end_time).

    Returns:
    int: 1 for demonstration purposes.
    """
    if num <= 0 or meetings is None:
        raise ValueError("Pass valid input")

    for meeting in meetings:
        for time in meeting:
            print(time)

    return 1

# Example usage
if __name__ == "__main__":
    N1 = 2
    meetings1 = [[0, 17], [1, 5], [5, 7]]

    N2 = 4
    meetings2 = [[0,12],[1,5],[2,7],[3,4],[4,5]]

    N = 2
    meetings = [[0, 6], [1, 5], [7, 8]]

    print("Max Rooms:", find_max_rooms(N, meetings))
    print("Max Rooms by Meeting Rooms:", find_max_meeting_rooms(N, meetings))
    print("Max Meeting:", find_max_meeting(N, meetings))
