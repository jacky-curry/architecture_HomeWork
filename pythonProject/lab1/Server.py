import socket


def handle_req(client_socket):
    header = 'HTTP/1.1 200 0K\r\nContent-Type: text/html\r\n'
    with open("index.html") as file:
        content = file.read()

    header += 'Content-Length = {}\r\n\r\n'.format(len(content))
    response = header + content
    # 返回给client的内容
    client_socket.sendall(response.encode())


if __name__ == '__main__':
    # 指定协议
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # 让端口可以重复使用
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    # 绑定ip和端口
    server.bind(('localhost', 8080))
    # 监听
    server.listen(1)
    while True:
        # 等待连接
        clientsocket, address = server.accept()
        # 接收消息
        print('Client connect', address)
        # data = clientsocket.recv(1024)
        # clientsocket.send()
        handle_req(clientsocket)

