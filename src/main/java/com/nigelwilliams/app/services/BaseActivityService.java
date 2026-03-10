package com.nigelwilliams.app.services;

import com.nigelwilliams.app.models.BaseActivity;

import java.util.List;

public abstract class BaseActivityService {
    public abstract List<? extends BaseActivity> getAllActivities();
    public abstract BaseActivity addActivity(BaseActivity activity);
    public abstract BaseActivity updateActivity(BaseActivity activity);
    public abstract boolean deleteActivity(String id);
}
