# DFS (Depth-First Search) algorithm

def pre_order(node):
    if not node:
        return ""
    return f"{node[0]} {pre_order(node[1])}{pre_order(node[2])}" # Root, Left, Right
    
def in_order(node):
    if not node:
        return ""
    return f"{in_order(node[1])}{node[0]} {in_order(node[2])}" # Left, Root, Right
    
def post_order(node):
    if not node:
        return ""
    return f"{post_order(node[1])}{post_order(node[2])}{node[0]} " # Left, Right, Root
    
def main():
    root = ('N', ('O', ('P', ('R', None, None), ('N', None, None)), ('A', None, None)), ('P', ('K', None, None), ('O', None, None)))

    print("Pre-order traversal:", pre_order(root))
    print("In-order traversal:", in_order(root))
    print("Post-order traversal:", post_order(root))

if __name__ == "__main__":
    main()