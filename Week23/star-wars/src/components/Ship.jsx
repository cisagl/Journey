import React from 'react'
import Head from './Head'
import { useParams, useNavigate } from 'react-router-dom';
import { useContext } from 'react';
import GlobalContext from '../contexts/MainContext';

const Ship = () => {

  const { model } = useParams();
  const { starships } = useContext(GlobalContext);
  const navigate = useNavigate();

  const ship = starships.find(ship => ship.model === model);

  const modelSrcMap = [
    { model: "CR90 corvette", src: "https://i.redd.it/zwbd3547t1z91.jpg" },
    {
      model: "Imperial I-class Star Destroyer",
      src: "https://lumiere-a.akamaihd.net/v1/images/Star-Destroyer_ab6b94bb.jpeg?region=0%2C0%2C1600%2C900",
    },
    {
      model: "Sentinel-class landing craft",
      src: "https://fractalsponge.net/wp/wp-content/uploads/2022/02/sentinel2-scaled.jpg",
    },
    {
      model: "DS-1 Orbital Battle Station",
      src: "https://i.redd.it/afzj85xndqe61.jpg",
    },
    {
      model: "YT-1300 light freighter",
      src: "https://www.lafosadelrancor.com/wp-content/uploads/2018/05/Millennium-Falcon-Modified-Corellian-Engineering-Corporation-YT-1300-Light-Freighter.jpg",
    },
    {
      model: "BTL Y-wing",
      src: "https://cdna.artstation.com/p/assets/images/images/043/335/790/large/miguelangel-front2.jpg?1636993184",
    },
    {
      model: "T-65 X-wing",
      src: "https://cdn.rebrickable.com/media/thumbs/mocs/moc-63672.jpg/1000x800.jpg",
    },
    {
      model: "Twin Ion Engine Advanced x1",
      src: "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/49651556-530d-4514-9701-d1cefd8f88b8/d9ugqvb-01b06e98-8098-4643-9ede-f68ad29c507b.jpg/v1/fill/w_1024,h_726,q_75,strp/twin_ion_engine_mkii_by_ameeeeba_d9ugqvb-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NzI2IiwicGF0aCI6IlwvZlwvNDk2NTE1NTYtNTMwZC00NTE0LTk3MDEtZDFjZWZkOGY4OGI4XC9kOXVncXZiLTAxYjA2ZTk4LTgwOTgtNDY0My05ZWRlLWY2OGFkMjljNTA3Yi5qcGciLCJ3aWR0aCI6Ijw9MTAyNCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.kN4K8VIfq4HNSX2ZL9NmbmSY1meY1Wq85dOjfVQGMIk",
    },
    {
      model: "Executor-class star dreadnought",
      src: "https://img.wattpad.com/3d46ef84e1d39a50a269aeecf6c1b24c479f323b/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f3631776a3179644861355a4c4c773d3d2d3334352e313637326239666164393938316632323230313231373635363239332e6a7067?s=fit&w=720&h=720",
    },
    {
      model: "GR-75 medium transport",
      src: "https://swrpggm.com/wp-content/uploads/2021/02/GR75_FE.png",
    },
  ];

  return (
    <div>
      <Head />

      <button onClick={() => navigate(-1)}>Go back</button>
      <div className='mainCard details'>
        <img src={
                  modelSrcMap.find((item) => item.model === ship.model)
                    ?.src || "https://picsum.photos/200/300"
                } alt="" 
                />
        <h2>Adı: {ship.name}</h2>
        <h2>Modeli: {ship.model}</h2>
        <h2>Yolcu sayısı: {ship.passengers}</h2>
        <h2>Atmosferdeki maksimum hız: {ship.max_atmosphering_speed}</h2>
        <h2>Üretici: {ship.manufacturer}</h2>
        <h2>Mürettebat: {ship.crew}</h2>
        <h2>Kargo kapasitesi: {ship.cargo_capacity}</h2>
      </div>
    </div>
  )
}

export default Ship