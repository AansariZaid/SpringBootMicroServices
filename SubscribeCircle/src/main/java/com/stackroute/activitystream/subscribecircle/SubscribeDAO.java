package com.stackroute.activitystream.subscribecircle;

public interface SubscribeDAO {

	Boolean subscribeCircle(int circleId, String userEmailId);

	Boolean unSubscribeCircle(int circleId, String userEmailId);

}
