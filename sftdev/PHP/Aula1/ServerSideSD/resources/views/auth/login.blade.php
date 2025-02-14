@extends('layouts.main_layout')
@section('content')

<form method="POST" action=" {{ route('login') }} ">
    @csrf
    <div class="mb-3">
      <label for="emailInput" class="form-label">Email address</label>
      <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp">
      <div hidden id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
      <label for="passwordInput" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="passwordInput">
    </div>
    <div class="mb-3">
        <a href="{{route('password.request')}}">Esqueceu-se da password?</a>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>

@endsection
