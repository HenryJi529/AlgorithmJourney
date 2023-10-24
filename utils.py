from timeit import default_timer as timer
import colorama


def colored_print(var, end: str = "\n"):
    formatted_output = (
        colorama.Fore.YELLOW
        + colorama.Style.BRIGHT
        + str(var)
        + colorama.Style.RESET_ALL
    )
    print(formatted_output, end=end)


def time(func):
    def wrapper(*args, **kwargs):
        start_time = timer()
        result = func(*args, **kwargs)
        end_time = timer()
        execution_time = end_time - start_time
        print(f"[INFO] {func.__name__} Running Time: {execution_time:.3f} seconds")
        return result

    return wrapper
