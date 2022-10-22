
# Lab 1: Logical Equivalent

# ให้นักศึกษาเพิ่มเติมโค้ดด้านล่าง
# ชื่อ-สกุล: นายนพกร แก้วสลับนิล
# รหัสนักศึกษา: 65050437


######## ห้ามแก้ไขโค้ดส่วนนี้ ########
# ********** เริ่มต้น **************

from functools import partial
import re


class Infix(object):
    def __init__(self, func):
        self.func = func

    def __or__(self, other):
        return self.func(other)

    def __ror__(self, other):
        return Infix(partial(self.func, other))

    def __call__(self, v1, v2):
        return self.func(v1, v2)


@Infix
def implies(p, q):
    return not p or q


@Infix
def iff(p, q):
    return (p | implies | q) and (q | implies | p)

# ********** สิ้นสุด **********


############# เขียนฟังก์ชันต่อไปนี้  ##############
###### ห้ามแก้ไข function definitions #########


# ฟังชั่นก์สร้างตาราง Truth Table
# input: expression
# output: truth table as a list of lists
# หมายเหตุ ตัวแปรในประพจน์มีเพียง a และ b เท่านั้น
def truth_table(expression):
    tt = [[], [], [], []]

    a = True
    b = True
    tt[0] = [a, b, eval(expression)]
    a = True
    b = False
    tt[1] = [a, b, eval(expression)]
    a = False
    b = True
    tt[2] = [a, b, eval(expression)]
    a = False
    b = False
    tt[3] = [a, b, eval(expression)]

    return tt


# คืนค่า True ถ้า expr1 สมมูลกับ expr2 และ False ถ้าไม่ใช่
# input: expr1, expr2
# output: bool
def are_equivalent(expr1, expr2):
    tt1 = truth_table(expr1)
    print(f'tt1 => {tt1}')

    tt2 = truth_table(expr2)
    print(f'tt2 => {tt2}')

    return tt1 == tt2

# Teera Ace Siriteerakul


# สามารถทดสอบโค้ดที่เขียนได้ด้วยฟังก์ชั่น main() นี้
def main():
    # ทดสอบฟังก์ชันสร้างตาราง Truth Table
    expression = 'a and (b |implies| a)'
    tt = truth_table(expression)
    print(f'\x1b[6;30;42m tt => {tt} \x1b[0m\n')

    # ทดสอบฟังก์ชันตรวจสอบความสมมูล
    expr1 = 'not a and b'
    expr2 = 'a |implies| b'
    equivalent = are_equivalent(expr1, expr2)
    if equivalent:
        print(
            f'The expression {expr1} & {expr2} are\u001b[32m equivalent!\u001b[0m')
    else:
        print(
            f'The expression {expr1} & {expr2} are\u001b[31m NOT equivalent!\u001b[0m')


if __name__ == '__main__':
    main()
    print("""
    ---------------------------------
    |   ชื่อ-สกุล: นายนพกร แก้วสลับนิล    |
    |   รหัสนักศึกษา: 65050437         |
    ---------------------------------
    """)
