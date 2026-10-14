;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 441)
(include sci.sh)
(use Main)
(use PolyPath)
(use Timer)
(use Motion)
(use System)

(public
	sCountessMeeting 0
	sCountessNoMeet 1
	sCountessLeaves 2
	sTalkWithCountess 3
	countTimer 4
)

(instance sCountessMeeting of Script
	(properties
		name {sCountessMeeting}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 3)
			)
			(1
				(= cycles 1)
			)
			(2
				(self setScript: sCountessEnters self)
			)
			(3
				((ScriptID 90 1) setMotion: PolyPath 141 171 self) ; aCountess
			)
			(4
				((ScriptID 90 1) view: 444 loop: 0 cel: 0) ; aCountess
				(gGame handsOn:)
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gTheIconBar enable: 7)
				(= cycles 1)
			)
			(5
				(= seconds 10)
			)
			(6
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gGame handsOff:)
				(= cycles 3)
			)
			(7
				(if (== (gEgo view:) 443)
					((ScriptID 90 1) setCycle: End self) ; aCountess
				else
					(gGame handsOn: 1)
					(self dispose:)
				)
			)
			(8
				(= seconds 2)
			)
			(9
				((ScriptID 90 1) setCycle: Beg self) ; aCountess
			)
			(10
				(= seconds 3)
			)
			(11
				(gGame handsOn: 1)
				(client setScript: sCountessLeaves)
			)
		)
	)
)

(instance sCountessNoMeet of Script
	(properties
		name {sCountessNoMeet}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 3)
			)
			(1
				(= cycles 1)
			)
			(2
				(self setScript: sCountessEnters self)
			)
			(3
				(if (and (gEgo has: 7) (not (IsFlag 120)))
					(gEgo setScript: sTalkWithCountess)
					(self dispose:)
				else
					(= seconds 2)
				)
			)
			(4
				(client setScript: sCountessLeaves)
			)
		)
	)
)

(instance sCountessEnters of Script
	(properties
		name {sCountessEnters}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				((ScriptID 90 1) ; aCountess
					moveTo: 440
					loop: 1
					x: 240
					y: 134
					actions: askQuestions
				)
				(if ((ScriptID 90 1) scaler:) ; aCountess
					(((ScriptID 90 1) scaler:) doit:) ; aCountess
				)
				(= cycles 1)
			)
			(1
				((ScriptID 90 1) view: 825) ; aCountess
				(if (== ((ScriptID 440 2) state:) 0) ; rm440Door
					((ScriptID 440 2) caller: self open:) ; rm440Door
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 90 1) setMotion: PolyPath 122 154 self) ; aCountess
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sCountessLeaves of Script
	(properties
		name {sCountessLeaves}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				else
					(gWalkHandler delete: gCurRoom)
					(gDirectionHandler delete: gCurRoom)
				)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 90 1) ; aCountess
					view: 825
					setCycle: Walk
					setMotion: PolyPath 122 154 self
				)
			)
			(2
				((ScriptID 90 1) setMotion: PolyPath 210 145 self) ; aCountess
			)
			(3
				(if (== ((ScriptID 440 2) state:) 0) ; rm440Door
					((ScriptID 440 2) caller: self open:) ; rm440Door
				else
					(= cycles 1)
				)
			)
			(4
				((ScriptID 90 1) setMotion: PolyPath 239 134 self) ; aCountess
			)
			(5
				((ScriptID 440 2) caller: self close:) ; rm440Door
			)
			(6
				(if (== (gEgo view:) 443)
					(gGame handsOn: 1)
					(gUser canControl: 1)
				else
					(gGame handsOn:)
				)
				((ScriptID 90 1) actions: 0 moveTo: 430 wandering: 1) ; aCountess
				(countTimer dispose:)
				(gGameMusic2 fade:)
				(WrapMusic pause: 0)
				(self dispose:)
				(DisposeScript 441)
			)
		)
	)
)

(instance sTalkWithCountess of Script
	(properties
		name {sTalkWithCountess}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo setMotion: PolyPath 100 172 self)
			)
			(1
				(gMessager say: 1 0 1 0 self 1440)
			)
			(2
				(SetFlag 120)
				(countTimer setReal: countTimer 15)
				(gGame handsOn: 1)
				(gTheIconBar enable: 1 2 5 6)
				(self dispose:)
			)
		)
	)
)

(instance askQuestions of Actions
	(properties
		name {askQuestions}
	)

	(method (doVerb param1)
		(return
			(switch param1
				(6
					(if (== (gEgo view:) 443)
						(gCurRoom setScript: (ScriptID 440 1)) ; sOutTapestry
					else
						(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							(1030
								(gMessager say: 1 6 2 0 0 1440)
								(countTimer
									seconds: (+ (countTimer seconds:) 10)
								)
							)
							(else
								(gMessager say: 1 6 4 0 0 1440)
								(countTimer seconds: 1)
							)
						)
					)
					1
				)
				(2
					(if (== (gEgo view:) 443)
						(gCurRoom setScript: (ScriptID 440 1)) ; sOutTapestry
					else
						(gMessager say: 1 2 0 0 0 1440)
					)
					1
				)
				(17
					(if (== (gEgo view:) 443)
						(gCurRoom setScript: (ScriptID 440 1)) ; sOutTapestry
					else
						(gMessager say: 1 17 0 0 0 1440)
						(countTimer seconds: (+ (countTimer seconds:) 10))
					)
					1
				)
				(else 0)
			)
		)
	)
)

(instance countTimer of Timer
	(properties
		name {countTimer}
	)

	(method (cue)
		(cond
			((not ((ScriptID 90 1) mover:)) ; aCountess
				((ScriptID 90 1) setScript: sCountessLeaves) ; aCountess
			)
			(((ScriptID 90 1) script:) ; aCountess
				(((ScriptID 90 1) script:) next: sCountessLeaves) ; aCountess
			)
		)
	)
)
