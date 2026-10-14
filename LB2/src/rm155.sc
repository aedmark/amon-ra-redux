;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm155 0
	Laura 2
)

(instance rm155 of LBRoom
	(properties
		name {rm155}
		picture 155
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 1155 156 157 155)
		(self setRegions: 92)
		(super init:)
		(gGameMusic2 number: 151 flags: 1 loop: -1 play:)
		(grass init: addToPic:)
		(moon init: addToPic:)
		(cloud1 init: addToPic:)
		(cloud2 init: addToPic:)
		(blue init: addToPic:)
		(lauraArm init: cycleSpeed: 15 setCycle: RandCycle)
		(fan init: setCycle: Fwd)
		(trees1 init: setScript: sMoveTrees1)
		(trees2 init: setScript: sMoveTrees2)
		(gCurRoom setScript: sCartoon)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(gGameMusic2 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sCartoon of Script
	(properties
		name {sCartoon}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				((ScriptID 1900 15) modeless: 1) ; Irmgaard
				(Laura modeless: 1)
				(= ticks 60)
			)
			(1
				(gMessager say: 1 0 0 0 self)
			)
			(2
				(gCurRoom newRoom: 160)
				(self dispose:)
			)
		)
	)
)

(instance sMoveTrees1 of Script
	(properties
		name {sMoveTrees1}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(trees1
					setLoop: 2
					xStep: 15
					yStep: 15
					setMotion: MoveTo 365 160 self
				)
			)
			(1
				(client x: 0 y: 79)
				(self changeState: 0)
			)
		)
	)
)

(instance sMoveTrees2 of Script
	(properties
		name {sMoveTrees2}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(trees2
					setLoop: 2
					xStep: 15
					yStep: 15
					setMotion: MoveTo 438 160 self
				)
			)
			(1
				(client x: 0 y: 79)
				(self changeState: 0)
			)
		)
	)
)

(instance trees1 of Actor
	(properties
		name {trees1}
		y 74
		view 155
		loop 2
		priority 3
		signal 16400
		moveSpeed 5
	)
)

(instance trees2 of Actor
	(properties
		name {trees2}
		y 74
		view 155
		loop 2
		cel 1
		priority 3
		signal 16400
		moveSpeed 5
	)
)

(instance fan of Prop
	(properties
		name {fan}
		x 157
		y 35
		view 157
		priority 14
		signal 16
	)
)

(instance lauraArm of Prop
	(properties
		name {lauraArm}
		x 144
		y 131
		view 156
	)
)

(instance Laura of Talker
	(properties
		name {Laura}
		x 0
		y 0
		view 1155
		loop 3
		disposeWhenDone 0
		talkWidth 150
		back 15
		textX 10
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(super init: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		name {lauraBust}
		view 1155
		loop 1
	)
)

(instance lauraEyes of Prop
	(properties
		name {lauraEyes}
		nsTop 85
		nsLeft 180
		view 1155
		loop 2
	)
)

(instance lauraMouth of Prop
	(properties
		name {lauraMouth}
		nsTop 90
		nsLeft 180
		view 1155
	)
)

(instance grass of View
	(properties
		name {grass}
		x 142
		y 87
		view 155
		loop 1
		priority 2
		signal 16400
	)
)

(instance moon of View
	(properties
		name {moon}
		x 140
		y 60
		view 155
		priority 1
		signal 16400
	)
)

(instance blue of View
	(properties
		name {blue}
		x 34
		y 71
		view 155
		loop 3
		cel 1
		priority 1
		signal 16400
	)
)

(instance cloud1 of View
	(properties
		name {cloud1}
		x 148
		y 48
		view 155
		loop 3
		priority 1
		signal 16400
	)
)

(instance cloud2 of View
	(properties
		name {cloud2}
		x 26
		y 47
		view 155
		loop 3
		priority 1
		signal 16400
	)
)
