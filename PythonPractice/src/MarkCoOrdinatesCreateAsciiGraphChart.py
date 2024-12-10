# Overview:
# Write a program, in any language, that will display an ASCII chart given the following data
# data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}.
# You should be able to print the surrounding components of the chart and then place an * where
# each data point is specified in the data set. You do not need to print the X and Y legends
# but that would be helpful. You are given the max x and max y but if you can calculate that
# it would be helpful.
#
#  Online auction graph display
#  x axis is time
#  y axis is price
#  Title item

#  Given a two-dimension array graph the price over time
#
#     +-----+-----+-----+-----+-----+-----+
#     +                             *     +
#     +                                   +
#     +                       *           +
#   $ +                                   +
#     +                                   +
#     +           *                       +
#     +     *                             +
#     +                 *                 +
#     +-----+-----+-----+-----+-----+-----+
#                time
#
#   max x = 5
#   max y = 8
#   data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}

# def say_hello():
#     print('Hello, World')

# for i in range(5):
#     say_hello()

class MarkCoOrdinatesCreateAsciiGraphChart:
    def __init__(self, data):
        self.data =data
        self.x_max = max(x for x, y in data)
        self.y_max = max(y for x, y in data)
        self.grid_matrix = [['     ' for _ in range(self.x_max + 2)] for _ in range(self.y_max + 2)]

    def plot_ascii(self):

        for x, y in self.data:
            self.grid_matrix[y][x] = '  *  '

    def draw(self):

        self.plot_ascii()

        print("      +-----+-----+-----+-----+-----+-----+ ")
        for row in reversed(self.grid_matrix[1:]):
            print ("      +", end = "  ")
            print(" ".join(row[1: self.x_max + 1]), end = "  ")
            print ("  +")
        print("      +-----+-----+-----+-----+-----+-----+ ")
        print("            1     2     3     4     5     time ")
        print("      $ is price ")

if __name__ == "__main__":
    data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}
    app = MarkCoOrdinatesCreateAsciiGraphChart(data)
    app.plot_ascii()
    app.draw()
