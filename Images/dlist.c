/*Laura Poulton
 * Tuesday 10 am
 * Lab 08 - dlist.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "dnode.h"
#include "dlist.h"

struct dlist *dlist_create() {
  
  //allocate space for the new struct dlist
  struct dlist *new_dlist = malloc(sizeof(struct dlist));

  new_dlist->front = NULL;
  new_dlist->back = NULL;
  new_dlist->counter = 0;

  //return pointer to the list
  return new_dlist;

}

struct dnode* dlist_add_front(struct dlist *l, char *str) {
  
  //insert new node in dlist before the first node
  struct dnode* new_node = dnode_create(str);
  if (l->counter == 0) {
    l->back = new_node;
  }
  else {
    new_node->next = l->front;
    l->front->prev = new_node;
  }
  l->front = new_node;

  //add to count of dlist
  l->counter = l->counter + 1;

   //return pointer to new_node
   return new_node;
}

struct dnode* dlist_add_back(struct dlist *l, char *str) {

  //insert new node in dlist after the last node
  struct dnode* new_node =  dnode_create(str);
   if (l->counter == 0) {
     l->front = new_node;
   }
   else {
     new_node->prev = l->back;
     l->back->next = new_node;
   }
   l->back = new_node;

  //add to count of dlist
  l->counter = l->counter + 1;

  //return pointer to new_node
  return new_node;
}

void dlist_destroy(struct dlist *l) {
  struct dnode* curr_node;
  curr_node = l->front;
  while (curr_node->next != NULL) {
    dnode_destroy(curr_node);
    curr_node = curr_node->next;
  }
  free(l);
}

uint32_t dlist_length(struct dlist *l) {
  return l->counter;
}

int dnode_cmp(struct dnode *n, char *str);

struct dnode* dlist_find(struct dlist* l, char * str) {
//Return the first node where the string matches str (use dnode_cmp).
  struct dnode* curr_node;
  curr_node = l->front;
  while(dnode_cmp(curr_node, str) != 0) {
    if (curr_node->next == NULL) {
      return NULL;
    }
    curr_node = curr_node->next;
      }
  return curr_node;
}

struct dnode* dlist_insert_before(struct dlist* l, struct dnode* n, char * str) {
//Insert a new node with <str> before the node n.
  struct dnode *new_n = dnode_create(str);

  if (n->prev != NULL) {
    new_n->prev = n->prev;
    new_n->next = n;
    n->prev->next = new_n;
    n->prev = new_n;
  }

  else {
    new_n->prev = n->prev;
    new_n->next = n;
    n->prev = new_n;
    l->front = new_n;
  }
  l->counter = l->counter + 1;

  return new_n;
}

struct dnode* dlist_insert_after(struct dlist* l, struct dnode *n, char *str) {
//Insert a new node with <str> after the node n.
  struct dnode *new_n = dnode_create(str);

  if (n->next != NULL) {
    new_n->prev = n;
    new_n->next = n->next;
    n->next->prev = new_n;
    n->next = new_n;
  }

  else {
    new_n->prev = n;
    new_n->next = n->next;
    n->next = new_n;
    l->back = new_n;
  }

  l->counter = l->counter +1;

  return new_n;
}

struct dnode* dlist_remove(struct dlist* l, struct dnode* n) {
//Remove a node from the list (but does not destroy the node).
  if( n == l->back){
    n->prev->next = NULL;
    l->counter --;
    l->back = n->prev;
    n->next = NULL;
    n->prev = NULL;
    return n;
  }
  else if( n == l->front){
    n->next->prev = NULL;
    l->counter --;
    l->front = n->next;
    n->next = NULL;
    n->prev = NULL;
    return n;
  }
  n->prev->next = n->next;
  n->next->prev = n->prev;
  l->counter --;
  n->next = NULL;
  n->prev = NULL;
  return n;
  return NULL;
}

int dnode_cmp(struct dnode *n, char *str) {
  return strcmp(str, n->str);
}
