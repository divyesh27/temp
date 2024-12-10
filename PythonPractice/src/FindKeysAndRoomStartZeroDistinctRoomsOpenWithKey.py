from typing import List
class FindKeysAndRoomStartZeroDistinctRoomsOpenWithKey:

    def dfs(self, rooms, visited, index):
        if visited[index]:
            return

        visited[index] = True
        for room in rooms[index]:
            if not visited[room]:
                self.dfs(rooms, visited, room)

        return



    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = [False for i in range(n)]

        self.dfs(rooms, visited, 0)

        return sum(visited) == n

if __name__ == "__main__":
    app = FindKeysAndRoomStartZeroDistinctRoomsOpenWithKey()

    print (app.canVisitAllRooms([[1],[2],[3],[]]))
    print (app.canVisitAllRooms([[1,3],[3,0,1],[2],[0]]))