package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{}
