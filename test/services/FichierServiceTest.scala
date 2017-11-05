package services.user

import org.mockito.Mockito._
import org.junit.Test
import org.junit.Assert._
import repositories.FichierRepositoryComponent
import models._

class FichierServiceTest extends FichierServiceComponentImpl
                      with FichierRepositoryMockComponent {
    
    
    
    
    
    @Test
    def findByIdDefined() {
        val id = 1L
        val user = User(Option(id), "foo@test.com")
        when(userRepository.tryFindById(id)).thenReturn(Option(user))
                
        val retrievedUser = userService.tryFindById(id)
        
        assertEquals(user, retrievedUser.get)
        verify(userRepository).tryFindById(id)
    }
    
   

}

trait FichierRepositoryMockComponent extends FichierRepositoryComponent {
    
    override val FichierRepository = mock(classOf[FichierRepository])
    
}