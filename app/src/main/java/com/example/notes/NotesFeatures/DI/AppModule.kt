package com.example.notes.NotesFeatures.DI

import android.app.Application
import androidx.room.Room
import com.example.notes.NotesFeatures.DATA.REPOSITORYIMPL.NoteRepositoryImpl
import com.example.notes.NotesFeatures.DATA.ROOM.NotesDAO
import com.example.notes.NotesFeatures.DATA.ROOM.NotesDatabase
import com.example.notes.NotesFeatures.DOMAIN.REPOSITORY.NotesRepository
import com.example.notes.NotesFeatures.DOMAIN.USES_CASES.DeleteNoteUseCase
import com.example.notes.NotesFeatures.DOMAIN.USES_CASES.GLOBAL_USECASES.NotesUseCases
import com.example.notes.NotesFeatures.DOMAIN.USES_CASES.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNotesDatabase(app: Application):NotesDatabase{
        return Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            NotesDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun providesNotesRepository(db:NotesDatabase):NotesRepository{
        return NoteRepositoryImpl(db.notesDAO)
    }

    @Provides
    @Singleton
    fun providesNotesUseCases(repository: NotesRepository):NotesUseCases{
        return NotesUseCases(
            GetAllNotes = GetNotesUseCase(repository),
            DeleteNotes = DeleteNoteUseCase(repository)
        )
    }

}