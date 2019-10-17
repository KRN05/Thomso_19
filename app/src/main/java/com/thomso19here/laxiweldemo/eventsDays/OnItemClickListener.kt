package com.thomso19here.laxiweldemo.eventsDays

interface OnItemClickListener <T> {

    /**
     * Invokes once the item is clicked
     */
    fun onItemClick(item: T)
}