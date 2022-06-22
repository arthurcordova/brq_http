package com.mobwaysolutions.httpsample.interact

sealed class UsuariosInteract {

    object Loading : UsuariosInteract()
    object OnFinish : UsuariosInteract()

}
