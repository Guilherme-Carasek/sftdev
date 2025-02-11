@extends('layouts.main_layout')
@section('content')

    <h1>Editar informação de utilizador</h1>

    <div class="row justify-contents-center">
        <div class="col-12 col-lg-6">
            <form method="POST" action=" {{route('user.create')}} " enctype="multipart/form-data">
                @csrf
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nameInput" name="name"value=" {{ $user->name }} "  >
                    @error('name')
                        Nome inválido
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="adressInput" class="form-label">Morada</label>
                    <input type="text" class="form-control" id="adressInput" name="adress"
                        value=" {{ $user->adress }} " >
                    @error('adress')
                        Morada inválida
                    @enderror
                </div>
                <div>
                    <input type="file" name="photo">
                </div>
                    <input hidden type="text" value=" {{ $user->id }} " >
                <button type="submit" class="btn btn-info">Enviar</button>
            </form>
        </div>
    </div>
@endsection
