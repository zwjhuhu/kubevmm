import logging
import logging.handlers


def set_logger(fn):
    logger = logging.getLogger("logger")
    
    handler1 = logging.StreamHandler()
    handler2 = logging.FileHandler(filename=fn)
    
    logger.setLevel(logging.DEBUG)
    handler1.setLevel(logging.DEBUG)
    handler2.setLevel(logging.DEBUG)
    
    formatter = logging.Formatter("%(asctime)s %(name)s %(levelname)s %(message)s")
    handler1.setFormatter(formatter)
    handler2.setFormatter(formatter)
    
    logger.addHandler(handler1)
    logger.addHandler(handler2)
    return logger
