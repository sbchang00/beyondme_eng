package com.example.toronto.mystudyapp.model.local;
// Reference Link : https://github.com/googlesamples/android-architecture-components

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Completable;
import io.reactivex.Flowable;

import com.example.toronto.mystudyapp.model.data.local.User;

/**
 * Data Access Object for the users table.
 */
@Dao
public interface UserDao {

    /**
     * Get the user from the table. Since for simplicity we only have one user in the database,
     * this query gets all users from the table, but limits the result to just the 1st user.
     *
     * @return the user from the table
     */
    @Query("SELECT * FROM Users LIMIT 1")   // <= 1st user.
    Flowable<User> getUser();

    /**
     * Insert a user in the database. If the user already exists, replace it.
     *
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);
    //Completable insertUser(User user);  //<= Error occurs. It is related with "Completable" keyword.

    /**
     * Delete all users.
     */
    @Query("DELETE FROM Users")
    void deleteAllUsers();
}
