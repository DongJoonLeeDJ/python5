import React, { useEffect,useState } from 'react'
import './BoardSelect.css'
import axios from 'axios'

export const BoardSelect = () => {

    const [boards, setboards] = useState([]);

    useEffect(()=>{ 
        axios.get('http://localhost:8080/api/boards')
        .then((res)=>{ 
            // console.log(res.data.data);
            setboards(res.data.data);
        })
        .catch((error)=>{ console.log(error); })
    },[]);

    return (
        <div className='board_select'>
            <h1>BoardSelect</h1>
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>순번</th>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        { 
                            boards.map((board)=>(
                                <tr key={board.id}>
                                    <td>{board.id}</td>
                                    <td>{board.title}</td>
                                    <td>{board.wdate}</td>
                                    <td>{board.count}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}
