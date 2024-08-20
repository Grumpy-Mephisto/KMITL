from socket import *

serverName = "127.0.0.1" # IP Server
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_DGRAM)

while True:
    message = input("Input lowercase sentence: ")
    if message.lower() == "exit":
        break
    clientSocket.sendto(message.encode(), (serverName, serverPort))
    modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
    print("From Server:", modifiedMessage.decode())

clientSocket.close()
print("Connection closed")
