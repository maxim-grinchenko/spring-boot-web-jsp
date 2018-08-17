package com.resolution.repository;

public interface UserRepositoryMongo /*extends MongoRepository<User, Long> */{

//    //https://www.youtube.com/watch?v=nwM7A4TwU3M
//
//    @Query(fields = "{talks.title:1}")
//    List<User> findByTalksWhenBetween(Date from, Date to);
//
//    default List<Talk> findByTalksBetween (Date from, Date to){
//        List<User> users =findByTalksWhenBetween(from, to);
//        return users.stream().map(User::getTalks).flatMap(Collection::stream)
//            .filter(t -> isBetween(from, to, t)).collect(Collectors.toList());
//    }
//
//    default boolean isBetween (Date from, Date to, Talk time){
//        return time.getWhen().after(from) && time.getWhen().before(to);
//    }
}
