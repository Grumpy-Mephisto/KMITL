require_relative 'main'
require_relative 'main'

describe 'Graph' do
  before do
    @graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
  end
  describe '#initialize' do
    it 'initializes the nodes attribute' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.nodes).to eq({})
    end

    it 'builds the graph correctly' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.nodes).to eq({
        'A' => ['E'],
        'B' => [],
        'C' => [],
        'D' => ['F'],
        'E' => ['A', 'E'],
        'F' => ['D'],
        'G' => ['F', 'D', 'B'],
        'H' => ['C']
      })
    end
  end

  describe '#dfs' do
    it 'returns the correct result for a given start node' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.dfs('A')).to eq(['A', 'E', 'D', 'F', 'B', 'G', 'C', 'H'])
    end

    it 'handles an empty graph correctly' do
      graph = Graph.new('', [])
      expect(graph.dfs('A')).to eq([])
    end

    it 'handles a graph with a single node correctly' do
      graph = Graph.new('A', [''])
      expect(graph.dfs('A')).to eq(['A'])
    end

    it 'handles a graph with multiple connected components correctly' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.dfs('G')).to eq(['G', 'F', 'D', 'B'])
    end
  end

  describe '#bfs' do
    it 'returns the correct result for a given start node' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.bfs('A')).to eq(['A', 'E', 'D', 'B', 'F', 'G', 'C', 'H'])
    end

    it 'handles an empty graph correctly' do
      graph = Graph.new('', [])
      expect(graph.bfs('A')).to eq([])
    end

    it 'handles a graph with a single node correctly' do
      graph = Graph.new('A', [''])
      expect(graph.bfs('A')).to eq(['A'])
    end

    it 'handles a graph with multiple connected components correctly' do
      graph = Graph.new('ABCDEFGH', ['GFDB', 'AHC', 'B', 'AE', 'FD', 'AE', 'A', 'B'])
      expect(graph.bfs('G')).to eq(['G', 'F', 'D', 'B'])
    end
  end
end
