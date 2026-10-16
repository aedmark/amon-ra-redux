;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use Osc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
)

(instance rm530 of LBRoom
	(properties
		name {rm530}
		picture 530
		north 600
		south 510
		vanishingX 0
	)

	(method (init)
		(ClearFlag 184) ; a bulb that burned out earlier has cooled (PLAY-026)
		(LoadMany rsVIEW 530 541 542 831)
		(LoadMany rsSOUND 540 541 542 543 558)
		(gEgo init: normalize: 831 setScale: Scaler 105 0 190 0)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(north
				(SetFlag 31)
				(gEgo x: 236 y: 136)
				(self setScript: sUpStairs)
			)
			(south
				(self setScript: sEnterSouth)
			)
			(else
				(gEgo posn: 65 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (IsFlag 31) (IsFlag 33))
			(gWalkHandler addToFront: wallInside pit rearStairs)
		)
		(if (IsFlag 31)
			(if (IsFlag 32)
				(darkPassage init:)
				(lightBulb init: setCel: 1)
			else
				(lightBulb init:)
			)
		else
			(doorSeam init:)
			(secretDoor addToPic:)
		)
		(windows init:)
		(stairwellWall init:)
		(hallWall init:)
		(floor init:)
		(stairs init:)
		(pit init:)
		(wallInside init:)
		(rearStairs init:)
		(socket init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 16384)
				(self setScript: sExitSouth)
			)
			((StepOn gEgo 8192)
				(self setScript: sExitSouthWalk)
			)
			((and (StepOn gEgo 8) (IsFlag 32))
				(self setScript: sWarnDarkStairs)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 33)
			(gWalkHandler delete: wallInside pit rearStairs)
		)
		(super dispose:)
	)
)

(instance lightBulb of View
	(properties
		name {lightBulb}
		x 162
		y 109
		noun 14
		view 541
		loop 4
		priority 15
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (not cel)
					(gMessager say: noun param1 2)
				else
					(gMessager say: noun param1 1)
				)
			)
			(39
				(if (not cel)
					(gCurRoom setScript: sReadCarbonPaper)
				else
					(gMessager say: noun param1 4)
				)
			)
			(4
				; PLAY-026: a lit bulb was already changed; with the spare in
				; hand, Hand swaps it; a bulb that burned out during this visit
				; (flag 184) is still hot; otherwise it has cooled, and the
				; reply points Laura toward a spare bulb.
				(cond
					((not cel)
						(gMessager say: noun param1 2)
					)
					((gEgo has: 23)
						(gCurRoom setScript: sReplaceLightBulb)
					)
					((IsFlag 184)
						(gMessager say: noun param1 5)
					)
					(else
						(gMessager say: noun param1 1)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance darkPassage of View
	(properties
		name {darkPassage}
		x 111
		y 88
		noun 11
		view 530
		loop 1
		priority 5
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if (== (lightBulb cel:) 0)
					(gMessager say: 11 1 2)
				else
					(gMessager say: 11 1)
				)
			)
			(8
				(if (== (lightBulb cel:) 0)
					(gMessager say: 11 8 2)
				else
					(gMessager say: 11 8)
				)
			)
			(33
				(gCurRoom setScript: sReplaceLightBulb)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance secretDoor of View
	(properties
		name {secretDoor}
		x 113
		y 89
		noun 10
		view 530
		priority 13
		signal 16401
	)
)

(instance windows of Feature
	(properties
		name {windows}
		y 1
		noun 1
		sightAngle 40
		onMeCheck 2
	)
)

(instance stairs of Feature
	(properties
		name {stairs}
		y 1
		noun 6
		sightAngle 40
		onMeCheck 4
	)

	(method (initialize))
)

(instance rearStairs of Feature
	(properties
		name {rearStairs}
		y 1
		noun 6
		sightAngle 40
		onMeCheck 4096
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(3
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance pit of Feature
	(properties
		name {pit}
		y 1
		noun 7
		sightAngle 40
		onMeCheck 8
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(1
				(if (== (lightBulb cel:) 0)
					(gMessager say: 7 1 2)
				else
					(gMessager say: 7 1)
				)
			)
			(3
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance socket of Feature
	(properties
		name {socket}
		y 1
		noun 9
		sightAngle 40
		onMeCheck 16
	)
)

(instance doorSeam of Feature
	(properties
		name {doorSeam}
		y 1
		noun 5
		sightAngle 40
		onMeCheck 32
	)
)

(instance wallInside of Feature
	(properties
		name {wallInside}
		y 1
		noun 8
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb param1)
		(switch param1
			(3
				(if (and (IsFlag 33) (IsFlag 31))
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance stairwellWall of Feature
	(properties
		name {stairwellWall}
		y 1
		noun 2
		sightAngle 40
		onMeCheck 256
	)
)

(instance hallWall of Feature
	(properties
		name {hallWall}
		y 1
		noun 3
		sightAngle 40
		onMeCheck 512
	)
)

(instance floor of Feature
	(properties
		name {floor}
		y 1
		noun 15
		sightAngle 40
		onMeCheck 1024
	)
)

(instance sReplaceLightBulb of Script
	(properties
		name {sReplaceLightBulb}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= register (Sound new:))
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 541
					setLoop: 1
					setCel: 0
					posn: 153 158
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo setCycle: ScrewInBulb 6 register self)
			)
			(4
				(gGame points: 1 167)
				(sFX number: 558 play:)
				(lightBulb setCel: 0)
				(darkPassage hide:)
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				((ScriptID 21 1) doit: 792) ; dropCluesCode
				(gEgo normalize: 831 loop: 6 cel: 5 posn: 152 158)
				(ClearFlag 32)
				(SetFlag 33)
				(gEgo put: 23)
				(gWalkHandler addToFront: wallInside pit rearStairs)
				(lightBulb stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties
		name {sReadCarbonPaper}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 541
					setLoop: 2
					setCel: 0
					posn: 153 158
					setCycle: End self
				)
			)
			(3
				(gMessager say: 14 39 3)
				(gGame points: 1 170)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					put: 29
					setLoop: 6
					setCel: 5
					posn: 152 158
					normalize: 831
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWarnDarkStairs of Script
	(properties
		name {sWarnDarkStairs}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 165 self)
			)
			(1
				(gMessager say: 11 1 2 0 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFallStairs of Script ; UNUSED
	(properties
		name {sFallStairs}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 167 150 self)
			)
			(1
				(gEgo
					view: 542
					setLoop: 0
					setCel: 0
					posn: 169 148
					setCycle: End self
				)
			)
			(2
				(cutPassageBottomMask init:)
				(cutFloorMask init:)
				(gEgo
					setPri: 6
					yStep: 16
					setMotion: MoveTo (gEgo x:) 183 self
				)
				(sFX number: 542 flags: 1 setLoop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= ticks 120)
			)
			(4
				(sFX number: 543 play:)
				(= ticks 180)
			)
			(5
				(= global145 14) ; "Nice swan dive off the stairway."
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance cutPassageBottomMask of View
	(properties
		name {cutPassageBottomMask}
		x 111
		y 149
		view 530
		loop 2
		priority 14
		signal 16401
	)
)

(instance cutFloorMask of View
	(properties
		name {cutFloorMask}
		x 111
		y 178
		view 530
		loop 3
		priority 15
		signal 16401
	)
)

(instance sUpStairs of Script
	(properties
		name {sUpStairs}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 540 loop: -1 flags: 1 play:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 103 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 109 161 self)
			)
			(3
				(gGameMusic2 fade:)
				(gEgo setMotion: MoveTo 147 162 self)
			)
			(4
				(WrapMusic pause: 0)
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
				(gEgo setMotion: PolyPath 136 158 self)
			)
			(1
				(WrapMusic pause: 1)
				(gGameMusic2 number: 541 loop: -1 flags: 1 play:)
				(gEgo
					view: 541
					setLoop: 0
					setCel: 0
					posn: 127 165
					setPri: 12
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 831
					posn: 99 161
					setPri: -1
					setMotion: MoveTo 107 140 self
				)
			)
			(3
				(gEgo setMotion: PolyPath 221 147 self)
			)
			(4
				(gEgo edgeHit: 1)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
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
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sExitSouthWalk of Script
	(properties
		name {sExitSouthWalk}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(if (> (gEgo x:) 150)
					(gEgo setMotion: MoveTo 229 148 self)
				else
					(gEgo setMotion: MoveTo 88 147 self)
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		name {sEnterSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(if (> (Random 0 1) 0)
					(gEgo
						posn: 84 152
						setHeading: 270
						setMotion: MoveTo 58 161 self
					)
				else
					(gEgo
						posn: 238 155
						setHeading: 90
						setMotion: MoveTo 262 157 self
					)
				)
			)
			(1
				(if (and (IsFlag 31) (not (IsFlag 32)))
					(if (IsFlag 33)
						(gGame handsOn:)
						(self dispose:)
					else
						(gGame handsOn:)
						(= ticks 120)
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(SetFlag 32)
				(SetFlag 184) ; still hot until Laura leaves (PLAY-026)
				(sFX number: 558 play:)
				(lightBulb setCel: 1)
				(darkPassage init:)
				(= ticks 120)
			)
			(3
				(gMessager say: 12 0 1)
				(self dispose:)
			)
		)
	)
)

(class ScrewInBulb of Osc
	(properties
		name {ScrewInBulb}
		soundOsc 1
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 2)
			(= howManyCycles param2)
			(if (>= argc 3)
				(= soundOsc param3)
				(if (>= argc 4)
					(= caller param4)
				)
			)
		)
		(super init: param1 param2 param4)
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 4) (< temp0 3))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(soundOsc number: 553 play:)
		(super cycleDone:)
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
	)
)
