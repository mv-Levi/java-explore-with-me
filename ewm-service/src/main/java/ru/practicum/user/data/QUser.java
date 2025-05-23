package ru.practicum.user.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.Path;

import jakarta.annotation.Generated;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1L;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");
    public final NumberPath<Long> id = createNumber("id", Long.class);
    public final StringPath name = createString("name");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }
}
