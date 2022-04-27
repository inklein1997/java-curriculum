# Written Response

The "best" implementation depends on what your intended usage is. In this case, the concrete base class is not a very good solution, because it requires that we implement the `area()` and `perimeter()` methods. These implementations change depending on what `Shape` we're creating, and we're never going to instantiate the `Shape` class on its own.

The abstract approach is a better solution, since we can declare the `area()` and `perimeter()` methods as `abstract` and leave the implementation to the child classes.  It also allows for us to have shared properties (such as `name` and `color`) without having to declare those on each individual child.

The interface approach is also a better solution than concrete base class one.  In this case, we're essentially saying that there are no shared properties that we need each child to inherit, and all we're concerned about is that each child class have the `area()` and `perimeter()` methods.  So long as we don't need the shared properties, this is a good solution.

Choosing between the `abstract` and `interface` approaches depends entirely on whether we have those shared properties.

---
© 2019 Trilogy Education Services
