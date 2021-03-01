package com.example.android.architecture.blueprints.todoapp.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.filters.SmallTest
import com.example.android.architecture.blueprints.todoapp.data.Task
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class TasksDaoTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ToDoDatabase

    @Before
    fun initDb() {
        // Using an in-memory database so that the information stored here disappears when the
        // process is killed.
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ToDoDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() = database.close()


    //Your first DAO test will insert a task and then get the task by its id.

    @Test
    fun insertATask_getTaskById() = runBlockingTest {
        val taskDao = database.taskDao()
        val task = Task("Title", "Description")
        // GIVEN - Insert a task.
        taskDao.insertTask(task)

        // WHEN - Get the task by id from the database.
        val loaded = taskDao.getTaskById(task.id)


        // THEN - The loaded data contains the expected values.
        assertThat<Task>(loaded as Task, notNullValue())
        assertThat(loaded.id, `is`(task.id))
        assertThat(loaded.title, `is`(task.title))
        assertThat(loaded.description, `is`(task.description))
        assertThat(loaded.isCompleted, `is`(task.isCompleted))

    }


    @Test
    fun updateTaskAndGetById() = runBlockingTest {
        // 1. Insert a task into the DAO.
        val task = Task("Title", "Description")
        database.taskDao().insertTask(task)

        // 2. Update the task by creating a new task with the same ID but different attributes.
        task.title = "Title1"
        task.description = "Description1"
        database.taskDao().updateTask(task)

        // 3. Check that when you get the task by its ID, it has the updated values.
        val loaded = database.taskDao().getTaskById(task.id)

        // THEN - The loaded data contains the expected values.
        assertThat<Task>(loaded as Task, notNullValue())
        assertThat(loaded.id, `is`(task.id))
        assertThat(loaded.title, `is`("Title1"))
        assertThat(loaded.description, `is`("Description1"))
    }
}