package proyecto.api.mappers;

public interface IMapper<A, B> {
    B mapTo (A a);
    A mapFrom(B b);
}
