def greeting(n: int):
    print("hello")
    if n > 0:
        greeting(n - 1)


def factorial(n: int):
    if n == 1:
        return 1
    if n == 0:
        return 1
    return n * factorial(n - 1)


if __name__ == "__main__":
    greeting(5)
    print(factorial(5))
