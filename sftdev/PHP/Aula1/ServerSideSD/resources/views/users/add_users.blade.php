@extends('layouts.main_layout')
@section('content')

    <h1>Aqui podes adicionar utilizadores!!!</h1>

    <p><a href="{{ route('sara.add') }}">Clique aqui para adicionar sara</a></p>
    <div class="row justify-contents-center">
        <div class="col-12 col-lg-6">
            <form method="POST" action=" {{route('user.create')}} ">
                @csrf
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nameInput" name="name">
                    @error('name')
                        Nome inválido
                    @enderror
                </div>
                <div class="mb-3">
                <label for="emailInput" class="form-label">Email</label>
                <input type="email" class="form-control" id="emailInput" name="email">
                @error('email')
                        Email inválido
                @enderror
                </div>
                <div class="mb-3">
                <label for="passwordInput" class="form-label">Password</label>
                <input type="password" class="form-control" id="passwordInput" name="password">
                @error('password')
                        Password inválida
                @enderror
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
@endsection
