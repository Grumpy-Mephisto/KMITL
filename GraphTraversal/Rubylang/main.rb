class Graph
  attr_accessor :nodes

  # Initializes a new Graph object.
  #
  # @param l [String] The list of nodes.
  # @param v [Array<String>] The list of node neighbors.
  def initialize(l, v)
    @nodes = {}
    build_graph(l, v)
  end

  # Builds the graph by creating nodes and their neighbors.
  #
  # @param l [String] The list of nodes.
  # @param v [Array<String>] The list of node neighbors.
  def build_graph(l, v)
    l.each_char.with_index do |node, i|
      neighbors = v[i].chars
      @nodes[node] = neighbors
    end
  end

  # Performs a depth-first search traversal starting from the given node.
  #
  # @param start [String] The starting node for the traversal.
  # @return [Array<String>] The nodes visited during the traversal.
  def dfs(start)
    visited = {}
    result = []
    stack = [start]

    until stack.empty?
      node = stack.pop

      unless visited[node]
        result << node
        visited[node] = true

        @nodes[node].reverse_each do |neighbor|
          stack << neighbor unless visited[neighbor]
        end
      end
    end

    result
  end

  # Performs a breadth-first search traversal starting from the given node.
  #
  # @param start [String] The starting node for the traversal.
  # @return [Array<String>] The nodes visited during the traversal.
  def bfs(start)
    visited = {}
    result = []
    queue = []

    result << start
    visited[start] = true
    queue << start

    until queue.empty?
      current = queue.shift

      @nodes[current].each do |neighbor|
        unless visited[neighbor]
          result << neighbor
          visited[neighbor] = true
          queue << neighbor
        end
      end
    end

    result
  end
end

l = "ABCDEFGH"
v = [
  "GFDB",
  "AHC",
  "B",
  "AE",
  "FD",
  "AE",
  "A",
  "B"
]

graph = Graph.new(l, v)

puts "Adjacent Lists:"
graph.nodes.each do |node, neighbors|
  puts "#{node}: #{neighbors.join(' ')}"
end

print "DFS: "
dfs_result = graph.dfs(l[0])
puts dfs_result.join(' ')

print "BFS with Queue: "
bfs_result = graph.bfs(l[0])
puts bfs_result.join(' ')
