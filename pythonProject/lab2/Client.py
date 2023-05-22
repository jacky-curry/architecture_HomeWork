import os
import time
import socket

def start_client(addr, port):
    PLC_ADDR = addr
    PLC_PORT = port
    s = socket.socket()
    s.connect((PLC_ADDR, PLC_PORT))
    count = 0
    while True:
        msg = '进程{pid}发送数据'.format(pid=os.getpid())
        msg = msg.encode(encoding='utf-8')
        s.send(msg)
        recv_data = s.recv(1024)
        print(recv_data.decode(encoding='utf-8'))
        time.sleep(3)
        count += 1
        if count > 20:
            break

    s.close()

if __name__ == '__main__':
    start_client('127.0.0.1', 8801)