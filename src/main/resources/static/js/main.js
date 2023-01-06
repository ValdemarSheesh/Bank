var messageApi = Vue.resource('/message/Biba');

Vue.component('messages-row', {
  template: '<div><i>{{ message.id }}</i> {{ message.text }}</div>',
  props: ['message']
});

Vue.component('messages-list', {
  template: '<div><messages-row v-for="message in messages" :key="message.id":message="message" /></div>',
  props: ['messages'],
  created: function() {
  messageApi.get().then(result =>
  result.text().then(data => console.log(data)))
  }
});

var app = new Vue({
  el: '#app',
  template: '<messages-list :messages="messages" />',
  data: {
    messages: []
  }
});