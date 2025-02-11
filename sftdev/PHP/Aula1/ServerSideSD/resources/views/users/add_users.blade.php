@extends('layouts.main_layout')
@section('content')

    <h1>Aqui podes adicionar utilizadores!!!</h1>

    <div class="row justify-contents-center">
        <div class="col-12 col-lg-6">
            <form method="POST" action=" {{route('user.create')}} ">
                @csrf
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nameInput" name="name"
                        @if( $user->id != 0 ) value=" {{ $user->name }} " @endif >
                    @error('name')
                        Nome inválido
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="emailInput" class="form-label">Email</label>
                    <input type="email" class="form-control" id="emailInput" name="email"
                        @if( $user->id != 0 ) value=" {{ $user->email }} " @endif >
                    @error('email')
                            Email inválido
                    @enderror
                </div>
                @if( $user->id == 0 )
                    <div class="mb-3">
                        <label for="passwordInput" class="form-label">Password</label>
                        <input type="password" class="form-control" id="passwordInput" name="password">
                        @error('password')
                                Password inválida
                        @enderror
                    </div>
                @endif
                <div class="mb-3">
                    <label for="adressInput" class="form-label">Morada</label>
                    <input type="text" class="form-control" id="adressInput" name="adress"
                        @if( $user->id != 0 ) value=" {{ $user->adress }} " @endif >
                    @error('adress')
                        Morada inválida
                    @enderror
                </div>
                <button type="submit" class="btn btn-info">Enviar</button>
            </form>
        </div>
    </div>
@endsection
