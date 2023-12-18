package com.example.ordermanager02.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoUsers {
    @Query(
        "SELECT * FROM table_users"
    )
    fun getAllUsers(): LiveData<List<AppUser>>

    @Query(
        """       
INSERT INTO table_users (nameUser, secondNameUser, phone)
VALUES
    ('Иван', 'Иванов', '+79123456789'),
    ('Екатерина', 'Петрова', '+79123456788'),
    ('Михаил', 'Сидоров', '+79123456787'),
    ('Ольга', 'Козлова', '+79123456786'),
    ('Дмитрий', 'Морозов', '+79123456785');
            """
    )
    fun testDataUsers()

    @Query("DELETE FROM table_users")
    fun truncateUsers()


    @Query(
        "SELECT * FROM table_users"
    )
    fun getListUsers(): List<AppUser>

    @Insert
    fun insert(appUser: AppUser)

    @Delete
    fun delete(appUser: AppUser)


}
