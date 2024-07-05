#!/bin/bash

INTERFACE=$(ip -o -4 route show to default | awk '{print $5}')

if [ -z "$INTERFACE" ]; then
  echo "No network interface found."
  exit 1
fi

echo "Network Interface: $INTERFACE"

IP_ADDR=$(ip -o -4 addr show dev "$INTERFACE" | awk '{print $4}')
SUBNET_MASK=$(ifconfig "$INTERFACE" | grep -w 'inet' | awk '{print $4}')

DEFAULT_GATEWAY=$(ip route | grep default | awk '{print $3}')

DNS_SERVERS=$(nmcli dev show "$INTERFACE" | grep 'IP4.DNS' | awk '{print $2}')

echo "IP Address: $IP_ADDR"
echo "Subnet Mask: $SUBNET_MASK"
echo "Default Gateway: $DEFAULT_GATEWAY"
echo "DNS Servers: $DNS_SERVERS"
