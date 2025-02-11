@extends('layouts.main_layout')
@section('content')
<form method="POST" action="{{ route('password.update') }}">
    @csrf
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input name="email" value="{{ request()->email }}" type="email" class="form-control" id="exampleInputEmail1"
            aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="inputpassword" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="inputpassword">
    </div>
    <div class="mb-3">
        <label for="passwordconfirm" class="form-label">Password</label>
        <input name="password_confirmation" type="password" class="form-control" id="passwordconfirm">
    </div>
    <input type="hidden" name="token" value="{{ request()->token }}" id="">
    <button type="submit" class="btn btn-info">Confirmar</button>
</form>


@endsection
