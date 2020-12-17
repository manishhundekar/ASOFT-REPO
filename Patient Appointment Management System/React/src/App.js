import React, { Component } from 'react';
import Login from './components/loginComponent';
import store from './store'
import { Provider } from 'react-redux'

class App extends Component {

  render(){
    return (
      <Provider store={store}>
        <Login />
      </Provider>
    )
  }
}

export default App;