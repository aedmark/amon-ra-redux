;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Timer)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm510 0
	eastDoor 2
)

(local
	local0
	local1
)

(instance rm510 of LBRoom
	(properties
		name {rm510}
		noun 10
		picture 510
		north 530
		east 550
		south 520
		west 500
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 510 511 831)
		(if (and (== gAct 4) (== global111 11))
			(LoadMany rsVIEW 820 812 817)
			(Load rsSOUND 332)
		)
		(LoadMany rsSOUND 531 721)
		(gEgo init: normalize: 831 setScale: Scaler 120 75 190 120)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(521 ; meanWhile
				(gGame handsOff:)
				(gEgo posn: 86 175)
				(WrapMusic pause: 0)
				(self setScript: sOlympiaEnters)
			)
			(north
				(gEgo x: 278 y: 147)
				(self setScript: sEnterNorth)
			)
			(east
				(gEgo edgeHit: 0 setHeading: 180)
				(if (and (== gAct 4) (== global111 11))
					(WrapMusic pause: 1)
					(gGameMusic2 number: 332 loop: -1 flags: 1 play:)
					(olympia
						init:
						setCycle: StopWalk -1
						setScale: Scaler 140 20 190 0
					)
					(steve
						init:
						setCycle: StopWalk -1
						setScale: Scaler 140 20 190 0
					)
				else
					(WrapMusic pause: 0)
				)
				(self cue:)
			)
			(west
				(self setScript: sEnterWest)
			)
			(26 ; actBreak
				(WrapMusic init: 1 90 91 92 93)
				(= global111 11)
				(self setScript: sEnterWest)
			)
			(south
				(self cue:)
				(WrapMusic pause: 0)
				(if (== ((Inv at: 14) owner:) 0)
					(self setScript: sFollowOlympia)
					((Inv at: 14) owner: 630)
				)
			)
			(else
				(gEgo posn: 86 175)
				(WrapMusic pause: 0)
				(self cue:)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (IsFlag 31)
			(rodinDudeHead init: cel: (rodinDudeHead lastCel:) stopUpd:)
		else
			(rodinDudeHead init: stopUpd:)
		)
		(eastDoor init:)
		(statue1 init:)
		(statue2 init:)
		(statue3 init:)
		(statue4 init:)
		(arch init:)
		(rodinSeam init:) ; the neck stays clickable with the head up (PLAY-029)
		(rodinBody init:)
		(transom init:)
		(wall init:)
		(southExitFeature init:)
		(if (OneOf global111 0 6 10 14)
			(eastDoor locked: 1)
		)
		(if
			(and
				(== gAct 4)
				(not (== gPrevRoomNum 521)) ; meanWhile
				(not (IsFlag 62))
				(TimeCheck $4108 1) ; can 4:15 am occur?
				(not (IsFlag 92))
			)
			(SetFlag 62)
			(self setScript: sMeanwhile)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(self setScript: sExitWest)
			)
			((StepOn gEgo 4)
				(self setScript: sExitNorth)
			)
			((StepOn gEgo 2048)
				(gCurRoom setScript: sExitSouth)
			)
		)
	)

	(method (cue)
		(cond
			((== global111 0)
				(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
					(gGame handsOff:)
					((ScriptID 90 2) goTo: 550 self) ; aOlympia
				else
					((ScriptID 90 2) moveTo: -2) ; aOlympia
					(waterPrompt setReal: waterPrompt 5)
				)
			)
			((OneOf global111 4 10 12)
				(waterPrompt setReal: waterPrompt 5)
			)
		)
	)

	(method (newRoom param1)
		(if (gTimers contains: waterPrompt)
			(waterPrompt dispose: delete:)
		)
		(cond
			((OneOf param1 500 530)
				(switch global111
					(3
						(++ global111)
					)
					(5
						(+= global111 2)
					)
					(6
						(++ global111)
					)
					(13
						(++ global111)
					)
				)
			)
			((== param1 520)
				(WrapMusic pause: 1)
			)
		)
		(if (OneOf global111 1 11 15)
			((ScriptID 90 6) moveTo: -2) ; aYvette
		)
		(if
			(and
				(== global111 7)
				(== ((ScriptID 90 6) room:) -2) ; aYvette
				(not (TimeCheck $c304)) ; has 12:45 am occurred?
			)
			((ScriptID 90 6) moveTo: 510 goTo: 430) ; aYvette
		)
		(if local1
			(ClearFlag 31)
		)
		(if (!= param1 east)
			(ClearFlag 97)
		)
		(super newRoom: param1)
	)
)

(instance olympia of Actor
	(properties
		name {olympia}
		x 256
		y 184
		view 820
		cel 5
		priority 13
		signal 16400
	)
)

(instance steve of Actor
	(properties
		name {steve}
		x 285
		y 184
		view 812
		loop 1
		cel 4
		priority 13
		signal 16
	)
)

(instance yvette of Actor
	(properties
		name {yvette}
		x 309
		y 159
		view 817
		loop 1
		priority 13
		signal 16
	)
)

(instance rodinDudeHead of Prop
	(properties
		name {rodinDudeHead}
		x 166
		y 127
		noun 6
		view 511
		loop 1
		priority 14
		signal 16
		cycleSpeed 12
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb param1)
		; PLAY-029: with the head pushed up (flag 31), Look and Magnifier
		; describe the raised head instead of the face or the closed seam.
		; The neck hotspot now stays active in both positions.
		(switch param1
			(4
				(if (IsFlag 31)
					(ClearFlag 31)
				else
					(gGame points: 1 142)
					(SetFlag 31)
				)
				(rodinDudeHead setScript: sRodinFlipSwitch)
			)
			(1
				(if (IsFlag 31)
					(gMessager say: noun param1 1)
				else
					(super doVerb: param1)
				)
			)
			(8
				(if (IsFlag 31)
					(gMessager say: noun param1 1)
				else
					(gMessager say: 7 1)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance eastDoor of Door
	(properties
		name {eastDoor}
		x 319
		y 95
		noun 2
		modNum 1510
		sightAngle 40
		approachX 309
		approachY 163
		view 510
		priority 8
		signal 16
		entranceTo 550
		listenVerb 38
		moveToX 310
		moveToY 157
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 38)
	)

	(method (cue)
		(super cue:)
		(if (== state 0)
			(if (and (== gAct 4) (== global111 11))
				(self setScript: sSteveYvetteMeeting)
			)
			(if
				(and
					(== gAct 4)
					(not (== gPrevRoomNum 521)) ; meanWhile
					(not (IsFlag 62))
					(TimeCheck $4108 1) ; can 4:15 am occur?
					(not (IsFlag 92))
				)
				(SetFlag 62)
				(gCurRoom newRoom: 521)
			)
		)
	)

	(method (listen)
		(if (gTimers contains: waterPrompt)
			(waterPrompt dispose: delete:)
		)
		(switch global111
			(0
				(gMessager say: 2 38 2 0 0 1510)
				(++ global111)
			)
			(4
				(gMessager say: 2 38 5 0 0 1510)
				(++ global111)
			)
			(10
				(gMessager say: 2 38 6 0 0 1510)
				(++ global111)
			)
			(12
				(gCurRoom setScript: sListenToYvetteAndSteve)
				(++ global111)
			)
			(else
				(super listen:)
			)
		)
	)

	(method (createPoly)
		(super createPoly: 297 152 319 156 319 164 297 160)
	)
)

(instance statue1 of Feature
	(properties
		name {statue1}
		y 1
		noun 1
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb param1)
		(if (== param1 4)
			(gMessager say: 14 4)
		else
			(super doVerb: param1 &rest)
		)
	)
)

(instance statue2 of Feature
	(properties
		name {statue2}
		x 100
		y 1
		noun 2
		onMeCheck 64
	)

	(method (doVerb param1)
		(if (== param1 4)
			(gMessager say: 14 4)
		else
			(super doVerb: param1 &rest)
		)
	)
)

(instance statue3 of Feature
	(properties
		name {statue3}
		x 200
		y 1
		noun 3
		onMeCheck 128
	)

	(method (doVerb param1)
		(if (== param1 4)
			(gMessager say: 14 4)
		else
			(super doVerb: param1 &rest)
		)
	)
)

(instance statue4 of Feature
	(properties
		name {statue4}
		x 300
		y 1
		noun 4
		onMeCheck 256
	)

	(method (doVerb param1)
		(if (== param1 4)
			(gMessager say: 14 4)
		else
			(super doVerb: param1 &rest)
		)
	)
)

(instance arch of Feature
	(properties
		name {arch}
		y 1
		noun 5
		onMeCheck 16
	)
)

(instance rodinSeam of Feature
	(properties
		name {rodinSeam}
		x 160
		y 160
		noun 7
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (IsFlag 31)
					(ClearFlag 31)
				else
					(gGame points: 1 142)
					(SetFlag 31)
				)
				(rodinDudeHead setScript: sRodinFlipSwitch)
			)
			(1
				(if (IsFlag 31)
					(gMessager say: noun param1 1) ; opened neck (PLAY-029)
				else
					(super doVerb: param1)
				)
			)
			(8
				(if (IsFlag 31)
					(gMessager say: noun param1 1) ; opened neck (PLAY-029)
				else
					(super doVerb: param1)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rodinBody of Feature
	(properties
		name {rodinBody}
		x 160
		y 160
		noun 8
		sightAngle 40
		onMeCheck 16384
	)
)

(instance transom of Feature
	(properties
		name {transom}
		x 360
		y 84
		noun 9
		sightAngle 40
		onMeCheck 512
	)
)

(instance wall of Feature
	(properties
		name {wall}
		y 1
		noun 11
		onMeCheck 1024
	)
)

(instance sExitSouth of Script
	(properties
		name {sExitSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sExitWest of Script
	(properties
		name {sExitWest}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 setMotion: MoveFwd 20 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

(instance sEnterWest of Script
	(properties
		name {sEnterWest}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo posn: 18 150 setHeading: 90 setMotion: MoveFwd 30 self)
			)
			(1
				(gCurRoom cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		name {sExitNorth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveFwd 25 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties
		name {sEnterNorth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 225 setMotion: PolyPath 247 155 self)
			)
			(1
				(gCurRoom cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script ; UNUSED
	(properties
		name {sExitEast}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 setMotion: MoveFwd 20 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sRodinFlipSwitch of Script
	(properties
		name {sRodinFlipSwitch}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 186 185 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 511
					setLoop: 0
					cel: 0
					posn: 174 184
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(sFX number: 531 flags: 1 play:)
				(if (IsFlag 31)
					(rodinDudeHead setCycle: End self)
				else
					(rodinDudeHead setCycle: Beg self)
				)
				(gEgo normalize: 831 loop: 1 posn: 186 185)
			)
			(4
				(rodinDudeHead stopUpd:)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSteveYvetteMeeting of Script
	(properties
		name {sSteveYvetteMeeting}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gEgo setMotion: PolyPath 273 172 self)
			)
			(2
				(= ticks 60)
			)
			(3
				(Face gEgo steve)
				(= ticks 60)
			)
			(4
				(gMessager say: 1 0 1 1 self 1510)
			)
			(5
				(Face steve gEgo)
				(= ticks 60)
			)
			(6
				(gMessager say: 1 0 1 2 self 1510)
			)
			(7
				(Face olympia gEgo)
				(= ticks 60)
			)
			(8
				(Face olympia steve)
				(= ticks 60)
			)
			(9
				(gMessager say: 1 0 1 3 self 1510)
			)
			(10
				(= ticks 60)
			)
			(11
				(olympia
					setCycle: Walk
					setMotion: PolyPath (olympia x:) 250 self
				)
			)
			(12
				(olympia dispose:)
				(gEgo setMotion: PolyPath 256 184 self)
			)
			(13
				(Face gEgo steve)
				(Face steve gEgo)
				(= ticks 60)
			)
			(14
				(gMessager say: 1 0 3 0 0 1510)
				(= ticks 60)
			)
			(15
				(= ticks 60)
			)
			(16
				(eastDoor setCycle: End self)
				(doorSound number: 46 play:)
				(global95 delete: (eastDoor doorPoly:))
			)
			(17
				(= ticks 60)
			)
			(18
				(Face yvette steve)
				(= ticks 60)
			)
			(19
				(yvette
					init:
					setScale: Scaler 140 20 190 0
					setCycle: Walk
					setMotion: MoveTo 298 174 self
				)
			)
			(20
				(yvette setCycle: StopWalk -1)
				(= cycles 1)
			)
			(21
				(Face yvette steve)
				(= cycles 10)
			)
			(22
				(Face yvette gEgo)
				(= cycles 10)
			)
			(23
				(Face yvette steve)
				(= cycles 10)
			)
			(24
				(gMessager say: 1 0 1 17 self 1510)
			)
			(25
				(Face steve yvette self)
			)
			(26
				(= cycles 1)
			)
			(27
				(gMessager say: 1 0 1 18 self 1510)
			)
			(28
				(gMessager say: 1 0 1 19 self 1510)
			)
			(29
				(yvette setCycle: Walk setMotion: MoveTo 309 159 self)
			)
			(30
				(yvette hide: dispose:)
				(= cycles 1)
			)
			(31
				(Face steve eastDoor)
				(Face gEgo eastDoor)
				(= ticks 60)
			)
			(32
				(Face steve gEgo)
				(Face gEgo steve)
				(= ticks 60)
			)
			(33
				(gMessager say: 1 0 1 20 self 1510)
			)
			(34
				(gMessager say: 1 0 1 21 self 1510)
			)
			(35
				(gMessager say: 1 0 1 22 self 1510)
			)
			(36
				(steve setMotion: MoveTo 309 159 self)
			)
			(37
				(Face gEgo eastDoor)
				(steve hide:)
				(= cycles 1)
			)
			(38
				(eastDoor setCycle: Beg self)
				(doorSound number: 47 play:)
				(global95 add: (eastDoor doorPoly:))
				(= ticks 60)
			)
			(39
				(gGameMusic2 fade: 0 12 5 1)
				(= cycles 1)
			)
			(40
				(gMessager say: 1 0 1 23 self 1510)
			)
			(41
				(gMessager say: 1 0 1 24 self 1510)
			)
			(42
				((ScriptID 22 0) doit: 8961 self) ; triggerAndClock
			)
			(43
				(++ global111)
				(waterPrompt setReal: waterPrompt 3)
				(WrapMusic pause: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties
		name {sOlympiaEnters}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 15)
			)
			(1
				(olympia
					posn: 100 210
					setCycle: Walk
					setScale: Scaler 140 20 190 0
					setPri: -1
					setMotion:
						PolyPath
						(- (gEgo x:) 20)
						(gEgo y:)
						self
					init:
				)
				(= seconds 2)
			)
			(2
				(Face gEgo olympia)
			)
			(3
				(Face gEgo olympia self)
			)
			(4
				(Face olympia gEgo self)
			)
			(5
				(= cycles 1)
			)
			(6
				(olympia setCycle: StopWalk -1)
				(= cycles 1)
			)
			(7
				(= cycles 1)
			)
			(8
				(gMessager say: 1 0 24 0 self 1892)
			)
			(9
				(olympia setMotion: PolyPath 13 146 self)
			)
			(10
				(gGame handsOn:)
				(olympia dispose:)
				(ClearFlag 62)
				(self dispose:)
			)
		)
	)
)

(instance sFollowOlympia of Script
	(properties
		name {sFollowOlympia}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(SetFlag 31)
				(= local1 1)
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 20))
				(rodinDudeHead cel: (rodinDudeHead lastCel:))
				(olympia posn: 196 161 setScale: Scaler 140 20 190 0 init:)
				(= cycles 15)
			)
			(1
				(olympia
					setPri: -1
					setCycle: StopWalk -1
					setMotion: PolyPath 271 142 self
				)
			)
			(2
				(olympia dispose:)
				(gEgo init: setMotion: PolyPath 86 175 self)
			)
			(3
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)

(instance doorSound of Sound
	(properties
		name {doorSound}
		flags 5
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 15
	)
)

(instance sMeanwhile of Script
	(properties
		name {sMeanwhile}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(switch gPrevRoomNum
					((gCurRoom north:)
						(gEgo x: 278 y: 147)
						(self setScript: sEnterNorth self)
					)
					((gCurRoom west:)
						(self setScript: sEnterWest self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gCurRoom newRoom: 521)
			)
		)
	)
)

(instance sListenToYvetteAndSteve of Script
	(properties
		name {sListenToYvetteAndSteve}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gMessager say: 2 38 4 0 self 1510)
			)
			(1
				(SetFlag 75)
				(eastDoor doVerb: 4)
			)
		)
	)
)

(instance waterPrompt of Timer
	(properties
		name {waterPrompt}
	)

	(method (cue)
		(gMessager say: 16)
	)
)
