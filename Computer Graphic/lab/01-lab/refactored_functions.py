import matplotlib.pyplot as plt
import numpy as np


def calculate_slope(x1, y1, x2, y2):
    """Calculate the slope of a line given two points."""
    return (y2 - y1) / (x2 - x1)

def calculate_intercept(x, y, m):
    """Calculate the y-intercept of a line given a point and the slope."""
    return y - m * x

def draw_line(m, c):
    """Draw a line given the slope and y-intercept."""
    x = np.linspace(-10, 10, 400)
    y = m * x + c
    plt.plot(x, y)

def draw_points(x, y):
    """Plot the given points on the graph."""
    plt.scatter(x, y)

def main():
    """Draw a line from the top left to the bottom right of the screen."""
    x1, y1 = -10, 10
    x2, y2 = 10, -10
    m = calculate_slope(x1, y1, x2, y2)
    c = calculate_intercept(x1, y1, m)
    draw_line(m, c)
    draw_points(np.array([x1, x2]), np.array([y1, y2]))
    plt.show()

if __name__ == "__main__":
    main()
