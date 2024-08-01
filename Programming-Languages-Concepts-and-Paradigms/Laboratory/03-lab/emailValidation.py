import re


def validate_email(email: str) -> bool:
    pattern = r"^(?!www\.)(?!\.)[a-zA-Z0-9*\-\.]+@[a-zA-Z0-9\-]+\.[a-zA-Z]{2,}$"

    if re.match(pattern, email):
        local_part = email.split("@")[0]
        if ".." in local_part:
            return False
        return True
    return False


def test_validate_email() -> None:
    test_emails = [
        "avc@abc.com",
        "www.abc@abc.com",
        "@abc.abc.com",
        ".abc@abc.com",
        "abc@abc.c",
    ]

    for email in test_emails:
        if validate_email(email):
            print(f"{email} is a valid email")
        else:
            print(f"{email} is not a valid email")


if __name__ == "__main__":
    test_validate_email()
