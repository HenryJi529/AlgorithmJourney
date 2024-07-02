select MIN(abs(t1.x - t2.x)) shortest
from Point t1, Point t2
where
    t1.x != t2.x;