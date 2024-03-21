from collections import deque


def DFS(nodes, start):
    visited, stack, result = set(), [start], []
    
    while stack:
        node = stack.pop()
        if node not in visited:
            result.append(node)
            visited.add(node)
            stack.extend(reversed(nodes[node]))
            
    return ''.join(result)

def BFS(nodes, start):
    visited, queue, result = set(), deque([start]), []
    visited.add(start)
    
    while queue:
        node = queue.popleft()
        result.append(node)
        
        for neighbor in nodes[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
                
    return ''.join(result)

def main():
    nodes = {
        'A': ['G', 'F', 'D', 'B'],
        'B': ['A', 'H', 'C'],
        'C': ['B'],
        'D': ['A', 'E'],
        'E': ['F', 'D'],
        'F': ['A', 'E'],
        'G': ['A'],
        'H': ['B'],
    }

    print("DFS:", DFS(nodes, 'A'))
    print("BFS:", BFS(nodes, 'A'))

if __name__ == "__main__":
    main()