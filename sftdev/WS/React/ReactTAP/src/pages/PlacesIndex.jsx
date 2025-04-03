import { useCallback, useEffect, useRef, useState } from 'react';
import globe from '../assets/globe.png'
import Places from '../components/places/Places';
import { updatePlaces } from '../https';

export default function AvailablePlaces() {  

    const [availablePlaces, setPlaces] = useState(null);
    const [userPlaces, setUserPlaces] = useState(null);
    const selectedPlace = useRef(null);

    useEffect(() => {
      fetch("http://localhost:3000/places")
        .then((response) => response.json())
        .then((resData) => {
          setPlaces(resData.places);
        });
    }, []);

    function handleSelectPlace(selectedPlace) {
      setUserPlaces((prevPickedPlaces) => {
        if (!prevPickedPlaces) {
          prevPickedPlaces = [];
        }
        if (prevPickedPlaces.some((place) => place.id === selectedPlace.id)) {
          return prevPickedPlaces;
        }
        return [selectedPlace, ...prevPickedPlaces];
      });
    
      //faz pedido put para o backend
      updatePlaces([selectedPlace, ...userPlaces]);
    }

    const handleRemovePlace = useCallback(
      async function handleRemovePlace() {
        setUserPlaces((prevPickedPlaces) =>
          prevPickedPlaces.filter((place) => place.id !== selectedPlace.current.id)
        );
        updatePlaces(
          userPlaces.filter((place) => place.id != selectedPlace.current.id)
        );
    
        setModalIsOpen(false);
      },
      [userPlaces]
    );
    
    function handleStartRemovePlace(place) {
      selectedPlace.current = place;
      handleRemovePlace();
    }

    return (
      <>
      <div>
        <img src={globe} alt="Stylized globe" />
        <h1>PlacePicker</h1>
        <p>
          Create your personal collection of places you would like to visit or
          you have visited.
        </p>
      </div>
      <main>
        <Places 
          title="My carinosn"
          fallbackText="no carniunos"
          places= {userPlaces}
          onSelectPlace={handleStartRemovePlace}
        />

        <Places
          title="Available Places"
          fallbackText="No Places Available"
          places={availablePlaces}
          onSelectPlace={handleSelectPlace}
        />
      </main>
    </>
    );
  }