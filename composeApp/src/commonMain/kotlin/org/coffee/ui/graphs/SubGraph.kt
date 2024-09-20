package org.coffee.ui.graphs

import kotlinx.serialization.Serializable

sealed interface SubGraph{

    @Serializable
    data object Auth:SubGraph

    @Serializable
    data object Dashboard:SubGraph

}