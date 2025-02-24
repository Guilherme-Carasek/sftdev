@extends('layouts.main_layout')

@section('title')
    login
@endsection

@section('content')
    @if ($errors->any())
        <div class="alert alert-danger">
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <h1>Login</h1>
    <form method="POST" action=" {{ route('login') }} ">
        @csrf
        <div class="mb-3">
        <label for="InputEmail" class="form-label">Email address</label>
        <input type="email" class="form-control" id="InputEmail" name="email" >
        </div>
        <div class="mb-3">
        <label for="InputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="InputPassword" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>

    </form>

@endsection
