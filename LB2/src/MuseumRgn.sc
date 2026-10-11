;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use n027)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	MuseumRgn 0
	aCountess 1
	aOlympia 2
	aORiley 3
	aTut 4
	aWatney 5
	aYvette 6
	aZiggy 7
	fumeTimer 13
	meetingTimer 15
)

(local
	[local0 100] = [350 632 4 0 1 360 0 638 0 0 370 0 0 0 635 420 7 -1 0 624 500 15 0 608 0 510 512 128 64 31 520 0 0 575 0 530 -1 0 127 0 430 32 -1 0 94 440 28 33 64 0 448 24 0 99 0 450 0 0 103 16 454 0 111 0 0 480 95 0 0 0 490 63 0 0 0 550 0 0 639 0 600 2 12 -1 0 610 8 0 3 0 630 0 7 0 0 650 0 0 13 0]
	[local100 120] = [350 2 420 370 0 360 360 1 0 350 0 0 370 4 0 0 0 350 420 8 350 430 0 500 500 16 420 0 510 0 510 32 530 550 520 500 520 64 0 0 510 0 530 512 600 0 510 0 430 1 480 420 0 440 440 2 448 430 490 0 448 4 450 0 440 0 450 8 0 0 448 454 454 16 0 450 0 0 480 32 430 0 0 0 490 64 0 0 440 0 550 128 0 0 510 0 600 1 650 610 530 0 610 4 630 0 600 0 630 8 0 610 0 0 650 2 0 0 600 0]
	[local220 40] = [350 0 360 0 370 0 420 0 500 0 510 0 520 0 530 0 430 0 440 0 448 0 450 0 454 0 480 0 490 0 550 0 600 0 610 0 630 0 650 0]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1
		(switch param1
			(1 5)
			(2 6)
			(3 2)
		)
	)
	(for ((= temp0 0)) (< temp0 21) ((++ temp0))
		(if
			(==
				(= temp2
					(switch param1
						(1 [local0 (* temp0 temp1)])
						(2 [local100 (* temp0 temp1)])
						(3 [local220 (* temp0 temp1)])
					)
				)
				param2
			)
			(return (* temp0 temp1))
		)
	)
)

(class MuseumRgn of Rgn
	(properties
		sel_20 {MuseumRgn}
		sel_631 0
		sel_632 0
		sel_633 0
		sel_634 0
		sel_635 0
		sel_636 0
		sel_637 0
		sel_638 0
		sel_639 0
		sel_640 0
		sel_641 0
		sel_642 0
		sel_643 0
		sel_678 0
		sel_679 0
	)

	(method (sel_110)
		(super sel_110:)
		(self sel_645:)
		(if (not (IsFlag 6))
			((ScriptID 90 1) sel_110:) ; aCountess
		)
		((ScriptID 90 2) sel_110:) ; aOlympia
		((ScriptID 90 3) sel_110:) ; aORiley
		((ScriptID 90 4) sel_110:) ; aTut
		(if (not (IsFlag 3))
			((ScriptID 90 5) sel_110:) ; aWatney
		)
		(if (not (IsFlag 5))
			((ScriptID 90 6) sel_110:) ; aYvette
		)
		(if (not (IsFlag 2))
			((ScriptID 90 7) sel_110:) ; aZiggy
		)
		(gKeyDownHandler sel_129: self)
		(if (not (gTimers sel_122: wanderTimer))
			(wanderTimer sel_162: wanderTimer 120)
		)
	)

	(method (sel_111)
		(if (gTimers sel_122: wanderTimer)
			(wanderTimer sel_111: sel_81:)
		)
		(super sel_111:)
	)

	(method (sel_399 param1)
		(= sel_406
			(OneOf
				param1
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
		)
		(= sel_407 0)
		(gKeyDownHandler sel_81: self)
		(if (gCurRoom sel_259:)
			(DisposeScript (+ 2000 gCurRoomNum))
		)
		(if sel_631
			(sel_631 sel_111:)
			(= sel_631 0)
			(if (IsObject sel_639)
				(sel_639 sel_111:)
			)
			(= sel_639 0)
			(DisposeScript sel_632)
		)
		(if sel_633
			(sel_633 sel_111:)
			(= sel_633 0)
			(if (IsObject sel_640)
				(sel_640 sel_111:)
			)
			(= sel_640 0)
			(DisposeScript sel_634)
		)
		(if sel_635
			(sel_635 sel_111:)
			(= sel_635 0)
			(if (IsObject sel_641)
				(sel_641 sel_111:)
			)
			(= sel_641 0)
			(DisposeScript sel_636)
		)
		(if sel_637
			(sel_637 sel_111:)
			(= sel_637 0)
			(if (IsObject sel_642)
				(sel_642 sel_111:)
			)
			(= sel_642 0)
			(DisposeScript sel_638)
		)
	)

	(method (sel_644 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (< argc 2)
			(= temp0 (localproc_0 3 param1))
			(return [local220 (++ temp0)])
		else
			(= temp3 param1)
			(= temp4 param2)
			(= temp1 1)
			(while (and temp3 (<= temp1 argc))
				(if (> temp3 0)
					(= [local220 (+ temp0 1)]
						(+
							[local220 (+ (= temp0 (localproc_0 3 temp3)) 1)]
							temp4
						)
					)
				)
				(= temp3 [param1 (++ temp1)])
				(= temp4 [param1 (++ temp1)])
			)
		)
	)

	(method (sel_680 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if
			(not
				(= temp1
					(switch param1
						((gCurRoom sel_409:)
							(MuseumRgn sel_631:)
						)
						((gCurRoom sel_410:)
							(MuseumRgn sel_633:)
						)
						((gCurRoom sel_411:)
							(MuseumRgn sel_635:)
						)
						((gCurRoom sel_412:)
							(MuseumRgn sel_637:)
						)
						(gCurRoomNum
							(gCurRoom sel_259:)
						)
						(else 0)
					)
				)
			)
			(return 1)
		)
		(= temp0 1)
		(for ((= temp3 0)) (and temp0 (< temp3 (temp1 sel_86:))) ((++ temp3))
			(if
				(or
					(and
						(== ((= temp2 (temp1 sel_64: temp3)) sel_31:) 3)
						(not (AvoidPath param2 param3 temp2))
					)
					(and (!= (temp2 sel_31:) 3) (AvoidPath param2 param3 temp2))
				)
				(= temp0 0)
			)
		)
		(if (not temp0)
			(switch param1
				((gCurRoom sel_409:)
					(= sel_678 ((MuseumRgn sel_639:) sel_621:))
					(= sel_679 ((MuseumRgn sel_639:) sel_622:))
				)
				((gCurRoom sel_410:)
					(= sel_678 ((MuseumRgn sel_640:) sel_621:))
					(= sel_679 ((MuseumRgn sel_640:) sel_622:))
				)
				((gCurRoom sel_411:)
					(= sel_678 ((MuseumRgn sel_641:) sel_621:))
					(= sel_679 ((MuseumRgn sel_641:) sel_622:))
				)
				((gCurRoom sel_412:)
					(= sel_678 ((MuseumRgn sel_642:) sel_621:))
					(= sel_679 ((MuseumRgn sel_642:) sel_622:))
				)
				(gCurRoomNum
					(= sel_678 ((MuseumRgn sel_643:) sel_621:))
					(= sel_679 ((MuseumRgn sel_643:) sel_622:))
				)
			)
		)
		(return temp0)
	)

	(method (sel_645)
		(if (gCurRoom sel_259:)
			((gCurRoom sel_259:) sel_111:)
		)
		(if sel_631
			(sel_631 sel_111:)
		)
		(if sel_633
			(sel_633 sel_111:)
		)
		(if sel_635
			(sel_635 sel_111:)
		)
		(if sel_637
			(sel_637 sel_111:)
		)
		(gCurRoom sel_259: (List sel_109:))
		((ScriptID (+ 2000 gCurRoomNum) 0) sel_57: (gCurRoom sel_259:))
		(if
			(OneOf
				(gCurRoom sel_409:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_632 (+ 2000 (gCurRoom sel_409:)))
			((ScriptID sel_632 0) sel_57: (= sel_631 (List sel_109:)))
		)
		(if
			(OneOf
				(gCurRoom sel_410:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_634 (+ 2000 (gCurRoom sel_410:)))
			((ScriptID sel_634 0) sel_57: (= sel_633 (List sel_109:)))
		)
		(if
			(OneOf
				(gCurRoom sel_411:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_636 (+ 2000 (gCurRoom sel_411:)))
			((ScriptID sel_636 0) sel_57: (= sel_635 (List sel_109:)))
		)
		(if
			(OneOf
				(gCurRoom sel_412:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_638 (+ 2000 (gCurRoom sel_412:)))
			((ScriptID sel_638 0) sel_57: (= sel_637 (List sel_109:)))
		)
		(= sel_643 (ScriptID (+ 2000 gCurRoomNum) 1))
		(if
			(OneOf
				(gCurRoom sel_409:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_639 (ScriptID sel_632 1))
		)
		(if
			(OneOf
				(gCurRoom sel_410:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_640 (ScriptID sel_634 1))
		)
		(if
			(OneOf
				(gCurRoom sel_411:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_641 (ScriptID sel_636 1))
		)
		(if
			(OneOf
				(gCurRoom sel_412:)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_642 (ScriptID sel_638 1))
		)
	)

	(method (sel_646)
		(if
			(OneOf
				gCurRoomNum
				((ScriptID 90 1) sel_620:) ; aCountess
				((ScriptID 90 2) sel_620:) ; aOlympia
				((ScriptID 90 3) sel_620:) ; aORiley
				((ScriptID 90 4) sel_620:) ; aTut
				((ScriptID 90 5) sel_620:) ; aWatney
				((ScriptID 90 6) sel_620:) ; aYvette
				((ScriptID 90 7) sel_620:) ; aZiggy
			)
			(gMessager sel_295: 16 46 0 0 0 0)
			(return 0)
		else
			(return 1)
		)
	)

	(method (sel_647 param1)
		(return
			(switch param1
				(gCurRoomNum
					(gCurRoom sel_259:)
				)
				((gCurRoom sel_409:) sel_631)
				((gCurRoom sel_410:) sel_633)
				((gCurRoom sel_411:) sel_635)
				((gCurRoom sel_412:) sel_637)
			)
		)
	)
)

(class MuseumActor of Actor
	(properties
		sel_20 {MuseumActor}
		sel_648 0
		sel_649 0
		sel_619 0
		sel_620 0
		sel_650 0
		sel_651 0
		sel_652 0
		sel_653 0
		sel_654 0
		sel_655 0
		sel_656 0
		sel_657 0
		sel_533 0
		sel_667 0
	)

	(method (sel_668 param1 param2 param3 param4 param5)
		(= sel_667 1)
		(museumDialogueResume sel_42: self)
		(self sel_312: 0)
		(gMessager
			sel_295: param1 param2 param3 param4 museumDialogueResume param5
		)
	)

	(method (sel_110 &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 [temp7 5])
		(self
			sel_2: (if (== sel_620 gCurRoomNum) sel_648 else 828)
			sel_316:
			sel_330:
			sel_15: 0
			sel_161: StopWalk -1
		)
		(if (gEgo sel_322:)
			(= temp2 (/ (* 110 ((gEgo sel_322:) sel_577:)) 100))
			(= temp3 ((gEgo sel_322:) sel_575:))
			(= temp4 (/ (* 110 (+ 1 ((gEgo sel_322:) sel_578:))) 100))
			(= temp5 ((gEgo sel_322:) sel_576:))
			(self sel_320: Scaler temp2 temp4 temp3 temp5)
		else
			(self sel_320: -1 gEgo)
			(= sel_106 (/ (* 110 sel_106) 100))
		)
		(super sel_110: &rest)
		(cond
			((not sel_649)
				(cond
					(sel_619
						(cond
							((== sel_620 gCurRoomNum) 0)
							((self sel_660:)
								(if
									(not
										(MuseumRgn sel_680: sel_620 sel_1 sel_0)
									)
									(self
										sel_153:
											(MuseumRgn sel_678:)
											(MuseumRgn sel_679:)
									)
								)
							)
							(else
								(self sel_153: 160 165)
							)
						)
						(if (> (MuseumRgn sel_644: sel_620) 1)
							(-= temp6 15) ; UNINIT
						)
						(self sel_664: sel_652 self)
					)
					((and (== sel_620 -1) (Random 0 1))
						(cond
							((== sel_620 gCurRoomNum)
								(if
									(not
										(MuseumRgn sel_680: sel_620 sel_1 sel_0)
									)
									(self
										sel_153:
											(MuseumRgn sel_678:)
											(MuseumRgn sel_679:)
									)
								)
							)
							((self sel_660:)
								(if
									(not
										(MuseumRgn sel_680: sel_620 sel_1 sel_0)
									)
									(self
										sel_153:
											(MuseumRgn sel_678:)
											(MuseumRgn sel_679:)
									)
								)
							)
							(else 0)
						)
						(self sel_664:)
					)
				)
			)
			(sel_652
				(cond
					((== sel_620 gCurRoomNum)
						(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
							(self
								sel_153:
									(MuseumRgn sel_678:)
									(MuseumRgn sel_679:)
							)
						)
					)
					((self sel_660:)
						(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
							(self
								sel_153:
									(MuseumRgn sel_678:)
									(MuseumRgn sel_679:)
							)
						)
					)
					(else 0)
				)
				(self sel_618: sel_652 self)
			)
			((== sel_620 sel_651)
				(= sel_651 0)
			)
		)
	)

	(method (sel_218)
		(if (== sel_2 828)
			(return 0)
		else
			(super sel_218: &rest)
		)
	)

	(method (sel_658 param1 &tmp temp0 temp1)
		(= temp0 (self sel_662: param1))
		(= temp1 (* sel_653 5))
		(cond
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 1)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 2)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 3)
			)
			((and (& [local0 (++ temp1)] temp0) (> [local0 temp1] 0))
				(return 4)
			)
			(else
				(return 0)
			)
		)
	)

	(method (sel_659 param1)
		(cond
			(
				(OneOf
					sel_620
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					335
					340
					350
					355
					360
					370
					400
				)
				(cond
					(
						(OneOf
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
						(= sel_651 420)
					)
					((OneOf param1 600 610 620 630 640 650 666)
						(= sel_651 530)
					)
				)
			)
			((OneOf sel_620 430 435 440 448 450 454 455 456 460 480 490 521)
				(if
					(not
						(OneOf
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
					)
					(= sel_651 430)
				)
			)
			(
				(and
					(OneOf sel_620 600 610 620 630 640 650 666)
					(not (OneOf param1 600 610 620 630 640 650 666))
				)
				(= sel_651 600)
			)
		)
		(return sel_651)
	)

	(method (sel_618 param1 param2 param3 param4)
		(= sel_649 1)
		(if (OneOf sel_620 -1 -2)
			(self sel_182: sel_652)
		)
		(= sel_651 (= sel_652 param1))
		(if (< argc 2)
			(= param2 0)
		)
		(if (> argc 2)
			(= sel_656 param3)
			(= sel_657 param4)
		else
			(= sel_657 (= sel_656 -1))
		)
		(self sel_146: (TravelToRoom sel_109:) param2)
	)

	(method (sel_660)
		(return
			(switch sel_620
				((gCurRoom sel_409:) 1)
				((gCurRoom sel_411:) 3)
				((gCurRoom sel_410:) 2)
				((gCurRoom sel_412:) 4)
				(else 0)
			)
		)
	)

	(method (sel_182 param1 &tmp temp0 temp1)
		(if (OneOf param1 -1 -2)
			(if (MuseumRgn sel_644: sel_620)
				(MuseumRgn sel_644: sel_620 -1)
			)
			(= sel_652 sel_620)
			(= sel_620 param1)
			(= sel_649 (= sel_619 0))
			(self sel_146: 0)
			(return)
		else
			(= sel_619 0)
			(self sel_146: 0)
			(= temp1 sel_620)
			(= sel_620 param1)
			(if (and (> temp1 0) (!= temp1 355) (!= param1 355))
				(self sel_663: sel_620)
				(= sel_650 (self sel_661: (self sel_658: temp1)))
				(MuseumRgn sel_644: sel_650 -1)
			)
			(= sel_2 (if (== sel_620 gCurRoomNum) sel_648 else 828))
			(MuseumRgn sel_644: sel_620 1)
		)
	)

	(method (sel_661 param1)
		(return [local100 (+ (* sel_653 6) param1 1)])
	)

	(method (sel_662 param1 &tmp temp0)
		(= temp0 (localproc_0 2 param1))
		(return [local100 (++ temp0)])
	)

	(method (sel_663 &tmp temp0)
		(= sel_653 (/ (= temp0 (localproc_0 2 sel_620)) 6))
	)

	(method (sel_664 param1 param2 param3 param4 &tmp temp0)
		(if (not argc)
			(while (== sel_620 (= temp0 [local100 (* (Random 0 22) 6)]))
				0
			)
		else
			(= temp0 param1)
		)
		(= sel_649 0)
		(= sel_619 1)
		(= sel_651 (= sel_652 temp0))
		(if (< argc 2)
			(= param2 0)
		)
		(if (> argc 2)
			(= sel_656 param3)
			(= sel_657 param4)
		else
			(= sel_657 (= sel_656 -1))
		)
		(= sel_533 10)
		(self sel_146: (TravelToRoom sel_109:) param2)
	)
)

(instance aCountess of MuseumActor
	(properties
		sel_20 {aCountess}
		sel_213 1
		sel_214 1884
		sel_323 514
		sel_648 813
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(if (not (SetFlag 112))
				(self sel_668: sel_213 param1 80 0 0 sel_214)
			else
				(super sel_300: param1)
			)
			(return)
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 0 global364)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 72 0 0 sel_214)
								(proc27_1 0 @global364)
							)
						)
						((proc27_0 0 global297)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 3 0 0 sel_214)
							(proc27_1 0 @global297)
						)
					)
				)
				(264
					(cond
						((or (IsFlag 143) (IsFlag 72))
							(if (proc27_0 0 global366)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 74 0 0 sel_214)
								(proc27_1 0 @global366)
							)
						)
						((proc27_0 0 global303)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 9 0 0 sel_214)
							(proc27_1 0 @global303)
						)
					)
				)
				(267
					(cond
						((or (IsFlag 158) (IsFlag 67))
							(if (proc27_0 0 global365)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 71 0 0 sel_214)
								(proc27_1 0 @global365)
							)
						)
						((proc27_0 0 global306)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 12 0 0 sel_214)
							(proc27_1 0 @global306)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET sel_214 sel_213 6 temp1 1))
							(self sel_668: sel_213 6 81 0 0 sel_214)
						)
						((proc27_0 0 [global296 (- temp1 2)])
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 0 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)

	(method (sel_145)
		(self sel_664:)
	)

	(method (sel_664 param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 sel_620)
			(while (== temp1 sel_620)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(cond
					((== gAct 3)
						(cond
							((<= temp0 5)
								(= temp1 450)
							)
							((<= temp0 10)
								(= temp1 454)
							)
							((<= temp0 50)
								(= temp1 500)
							)
						)
					)
					((<= temp0 40)
						(= temp1 500)
					)
				)
			)
			(if temp1
				(if (== sel_620 -1)
					(if (> sel_652 0)
						(self sel_182: sel_652)
					)
					(= sel_652 0)
				)
				(super sel_664: temp1 self)
			else
				(if (!= sel_620 -1)
					(= sel_652 sel_620)
				)
				(self sel_182: -1)
				(= sel_619 0)
			)
		else
			(super sel_664: param1 &rest)
		)
	)
)

(instance aOlympia of MuseumActor
	(properties
		sel_20 {aOlympia}
		sel_213 1
		sel_214 1892
		sel_103 1
		sel_648 820
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 3 global364)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 72 0 0 sel_214)
								(proc27_1 3 @global364)
							)
						)
						((proc27_0 3 global297)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 3 0 0 sel_214)
							(proc27_1 3 @global297)
						)
					)
				)
				(259
					(cond
						((or (IsFlag 171) (IsFlag 12))
							(if (proc27_0 3 global363)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 69 0 0 sel_214)
								(proc27_1 3 @global363)
							)
						)
						((proc27_0 3 global298)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 4 0 0 sel_214)
							(proc27_1 3 @global298)
						)
					)
				)
				(264
					(cond
						((or (IsFlag 143) (IsFlag 72))
							(if (proc27_0 3 global366)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 74 0 0 sel_214)
								(proc27_1 3 @global366)
							)
						)
						((proc27_0 3 global303)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 9 0 0 sel_214)
							(proc27_1 3 @global303)
						)
					)
				)
				(266
					(cond
						((or (IsFlag 161) (IsFlag 68))
							(if (proc27_0 3 global367)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 73 0 0 sel_214)
								(proc27_1 3 @global367)
							)
						)
						((proc27_0 3 global305)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 11 0 0 sel_214)
							(proc27_1 3 @global305)
						)
					)
				)
				(267
					(cond
						((or (IsFlag 158) (IsFlag 67))
							(if (proc27_0 3 global365)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 71 0 0 sel_214)
								(proc27_1 3 @global365)
							)
						)
						((proc27_0 3 global306)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 12 0 0 sel_214)
							(proc27_1 3 @global306)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET sel_214 sel_213 6 temp1 1))
							(self sel_668: sel_213 6 81 0 0 sel_214)
						)
						((proc27_0 3 [global296 (- temp1 2)])
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 3 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)

	(method (sel_145)
		(self sel_664:)
	)

	(method (sel_664 param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 sel_620)
			(while (== temp1 sel_620)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(cond
					((== gAct 3)
						(cond
							((<= temp0 15)
								(= temp1 650)
							)
							((<= temp0 25)
								(= temp1 450)
							)
							((<= temp0 35)
								(= temp1 454)
							)
							((<= temp0 85)
								(= temp1 520)
							)
						)
					)
					((<= temp0 30)
						(= temp1 650)
					)
					((<= temp0 80)
						(= temp1 520)
					)
				)
			)
			(if temp1
				(if (== sel_620 -1)
					(if (> sel_652 0)
						(self sel_182: sel_652)
					)
					(= sel_652 0)
				)
				(super sel_664: temp1 self)
			else
				(if (!= sel_620 -1)
					(= sel_652 sel_620)
				)
				(self sel_182: -1)
				(= sel_619 0)
			)
		else
			(super sel_664: param1 &rest)
		)
	)
)

(instance aORiley of MuseumActor
	(properties
		sel_20 {aORiley}
		sel_213 1
		sel_214 1888
		sel_648 818
	)

	(method (sel_110)
		(= sel_323 (if (== sel_2 818) 1282 else 770))
		(super sel_110: &rest)
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(if (not (SetFlag 114))
				(self sel_668: sel_213 param1 80 0 0 sel_214)
			else
				(super sel_300: param1)
			)
			(return)
		)
		(if (== param1 22)
			(super sel_300: param1)
			(if (gEgo sel_238: 11)
				(gEgo sel_351: 11)
			)
			(return)
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 4 global364)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 72 0 0 sel_214)
								(proc27_1 4 @global364)
							)
						)
						((proc27_0 4 global297)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 3 0 0 sel_214)
							(proc27_1 4 @global297)
						)
					)
				)
				(259
					(cond
						((or (IsFlag 171) (IsFlag 12))
							(if (proc27_0 4 global363)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 69 0 0 sel_214)
								(proc27_1 4 @global363)
							)
						)
						((proc27_0 4 global298)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 4 0 0 sel_214)
							(proc27_1 4 @global298)
						)
					)
				)
				(264
					(cond
						((or (IsFlag 143) (IsFlag 72))
							(if (proc27_0 4 global366)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 74 0 0 sel_214)
								(proc27_1 4 @global366)
							)
						)
						((proc27_0 4 global303)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 9 0 0 sel_214)
							(proc27_1 4 @global303)
						)
					)
				)
				(266
					(cond
						((or (IsFlag 161) (IsFlag 68))
							(if (proc27_0 4 global367)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 73 0 0 sel_214)
								(proc27_1 4 @global367)
							)
						)
						((proc27_0 4 global305)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 11 0 0 sel_214)
							(proc27_1 4 @global305)
						)
					)
				)
				(267
					(cond
						((or (IsFlag 158) (IsFlag 67))
							(if (proc27_0 4 global365)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 71 0 0 sel_214)
								(proc27_1 4 @global365)
							)
						)
						((proc27_0 4 global306)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 12 0 0 sel_214)
							(proc27_1 4 @global306)
						)
					)
				)
				(269
					(cond
						((or (IsFlag 69) (IsFlag 165) (IsFlag 166))
							(if (proc27_0 4 global365)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 70 0 0 sel_214)
								(proc27_1 4 @global365)
							)
						)
						((proc27_0 4 global308)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 14 0 0 sel_214)
							(proc27_1 4 @global308)
						)
					)
				)
				(780
					(cond
						((or (IsFlag 155) (IsFlag 22) (gEgo sel_238: 11))
							(if (proc27_0 4 global368)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 75 0 0 sel_214)
								(proc27_1 4 @global368)
							)
						)
						((proc27_0 4 global332)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 38 0 0 sel_214)
							(proc27_1 4 @global332)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET sel_214 sel_213 6 temp1 1))
							(self sel_668: sel_213 6 81 0 0 sel_214)
						)
						((proc27_0 4 [global296 (- temp1 2)])
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 4 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance aTut of MuseumActor
	(properties
		sel_20 {aTut}
		sel_213 1
		sel_214 1883
		sel_103 1
		sel_648 821
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(if (not (SetFlag 111))
				(self sel_668: sel_213 param1 80 0 0 sel_214)
			else
				(super sel_300: param1)
			)
			(return)
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 7 global364)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 72 0 0 sel_214)
								(proc27_1 7 @global364)
							)
						)
						((proc27_0 7 global297)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 3 0 0 sel_214)
							(proc27_1 7 @global297)
						)
					)
				)
				(266
					(cond
						((or (IsFlag 161) (IsFlag 68))
							(if (proc27_0 7 global367)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 73 0 0 sel_214)
								(proc27_1 7 @global367)
							)
						)
						((proc27_0 7 global305)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 11 0 0 sel_214)
							(proc27_1 7 @global305)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET sel_214 sel_213 6 temp1 1))
							(self sel_668: sel_213 6 81 0 0 sel_214)
						)
						((proc27_0 7 [global296 (- temp1 2)])
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 7 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)

	(method (sel_145)
		(self sel_664:)
	)

	(method (sel_664 param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 sel_620)
			(while (== temp1 sel_620)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 5)
						(= temp1 450)
						(continue)
					)
					(if (<= temp0 10)
						(= temp1 454)
					)
				)
			)
			(if temp1
				(if (== sel_620 -1)
					(if (> sel_652 0)
						(self sel_182: sel_652)
					)
					(= sel_652 0)
				)
				(super sel_664: temp1 self)
			else
				(if (!= sel_620 -1)
					(= sel_652 sel_620)
				)
				(self sel_182: -1)
				(= sel_619 0)
			)
		else
			(super sel_664: param1 &rest)
		)
	)
)

(instance aWatney of MuseumActor
	(properties
		sel_20 {aWatney}
		sel_213 1
		sel_214 1886
		sel_648 815
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(switch temp0
				(258
					(cond
						((IsFlag 134)
							(if (proc27_0 8 global364)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							else
								(self sel_668: sel_213 6 72 0 0 sel_214)
								(proc27_1 8 @global364)
							)
						)
						((proc27_0 8 global297)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 3 0 0 sel_214)
							(proc27_1 8 @global297)
						)
					)
				)
				(else
					(cond
						((not (Message msgGET sel_214 sel_213 6 temp1 1))
							(self sel_668: sel_213 6 81 0 0 sel_214)
						)
						((proc27_0 8 [global296 (- temp1 2)])
							(self sel_668: sel_213 6 1 0 0 sel_214)
						)
						(else
							(self sel_668: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 8 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)

	(method (sel_145)
		(self sel_664:)
	)

	(method (sel_664 param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 sel_620)
			(while (== temp1 sel_620)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 40)
						(= temp1 500)
						(continue)
					)
					(if (<= temp0 85)
						(= temp1 530)
					)
				)
			)
			(if temp1
				(if (== sel_620 -1)
					(if (> sel_652 0)
						(self sel_182: sel_652)
					)
					(= sel_652 0)
				)
				(super sel_664: temp1 self)
			else
				(if (!= sel_620 -1)
					(= sel_652 sel_620)
				)
				(self sel_182: -1)
				(= sel_619 0)
			)
		else
			(super sel_664: param1 &rest)
		)
	)
)

(instance aYvette of MuseumActor
	(properties
		sel_20 {aYvette}
		sel_213 1
		sel_214 1885
		sel_103 1
		sel_648 817
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(cond
			((== param1 2)
				(if (not (SetFlag 113))
					(self sel_668: sel_213 param1 80 0 0 sel_214)
				else
					(self sel_668: sel_213 param1 27 0 0 sel_214)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256
							(+ temp2 1)
						)
						(512
							(+ temp2 18)
						)
						(768
							(+ temp2 26)
						)
						(1024
							(+ temp2 61)
						)
					)
				)
				(switch temp0
					(267
						(cond
							((or (IsFlag 158) (IsFlag 67))
								(if (proc27_0 9 global365)
									(self sel_668: sel_213 6 1 0 0 sel_214)
								else
									(self sel_668: sel_213 6 71 0 0 sel_214)
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							)
							(else
								(self sel_668: sel_213 6 12 0 0 sel_214)
								(proc27_1 9 @global306)
							)
						)
					)
					(259
						(cond
							((or (IsFlag 171) (IsFlag 12))
								(if (proc27_0 9 global363)
									(self sel_668: sel_213 6 1 0 0 sel_214)
								else
									(self sel_668: sel_213 6 69 0 0 sel_214)
									(proc27_1 9 @global363)
								)
							)
							((proc27_0 9 global298)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							)
							(else
								(self sel_668: sel_213 6 4 0 0 sel_214)
								(proc27_1 9 @global298)
							)
						)
					)
					(258
						(cond
							((IsFlag 134)
								(if (proc27_0 9 global364)
									(self sel_668: sel_213 6 1 0 0 sel_214)
								else
									(self sel_668: sel_213 6 72 0 0 sel_214)
									(proc27_1 9 @global364)
								)
							)
							((proc27_0 9 global297)
								(self sel_668: sel_213 6 1 0 0 sel_214)
							)
							(else
								(self sel_668: sel_213 6 3 0 0 sel_214)
								(proc27_1 9 @global297)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(self sel_668: sel_213 6 1 0 0 sel_214)
						else
							(self sel_668: sel_213 6 24 0 0 sel_214)
							(proc27_1 9 @global302)
						)
					)
					(else
						(cond
							((not (Message msgGET sel_214 sel_213 6 temp1 1))
								(self sel_668: sel_213 6 81 0 0 sel_214)
							)
							((proc27_0 9 [global296 (- temp1 2)])
								(self sel_668: sel_213 6 1 0 0 sel_214)
							)
							(else
								(self sel_668: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 9 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance aZiggy of MuseumActor
	(properties
		sel_20 {aZiggy}
		sel_213 1
		sel_214 1890
		sel_648 816
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256
						(+ temp2 1)
					)
					(512
						(+ temp2 18)
					)
					(768
						(+ temp2 26)
					)
					(1024
						(+ temp2 61)
					)
				)
			)
			(cond
				((not (Message msgGET sel_214 sel_213 6 temp1 1))
					(self sel_668: sel_213 6 81 0 0 sel_214)
				)
				((proc27_0 11 [global296 (- temp1 2)])
					(self sel_668: sel_213 6 1 0 0 sel_214)
				)
				(else
					(self sel_668: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)

	(method (sel_145)
		(self sel_664:)
	)

	(method (sel_664 param1 &tmp temp0 temp1)
		(if (or (not argc) (not param1))
			(= temp1 sel_620)
			(while (== temp1 sel_620)
				(= temp1 0)
				(= temp0 (Random 1 100))
				(if (== gAct 3)
					(if (<= temp0 5)
						(= temp1 450)
						(continue)
					)
					(if (<= temp0 10)
						(= temp1 454)
					)
				)
			)
			(if temp1
				(if (== sel_620 -1)
					(if (> sel_652 0)
						(self sel_182: sel_652)
					)
					(= sel_652 0)
				)
				(super sel_664: temp1 self)
			else
				(if (!= sel_620 -1)
					(= sel_652 sel_620)
				)
				(self sel_182: -1)
				(= sel_619 0)
			)
		else
			(super sel_664: param1 &rest)
		)
	)
)

(class TravelToRoom of Script
	(properties
		sel_20 {TravelToRoom}
		sel_665 0
		sel_666 0
	)

	(method (sel_111 param1)
		(if (or (not argc) (not param1))
			(= sel_143 0)
		)
		(super sel_111:)
	)

	(method (sel_145)
		(if (sel_42 sel_667:)
			(return)
		else
			(super sel_145: &rest)
		)
	)

	(method (sel_144 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(switch (= sel_29 param1)
			(0
				(= sel_141 0)
				(= sel_136 1)
			)
			(1
				(if
					(and
						(==
							(= temp1 (sel_42 sel_659: (sel_42 sel_652:)))
							(sel_42 sel_620:)
						)
						(not sel_666)
					)
					(self sel_144: 9)
				else
					(if sel_666
						(++ sel_29)
					)
					(= sel_136 1)
				)
			)
			(2
				(= temp0 (* (sel_42 sel_663:) 11))
				(if (!= (sel_42 sel_651:) (sel_42 sel_620:))
					(= sel_141 (sel_42 sel_658: (sel_42 sel_651:)))
					(= temp6 (sel_42 sel_660:))
				)
				(= temp2
					(switch temp6
						(1
							(MuseumRgn sel_639:)
						)
						(2
							(MuseumRgn sel_640:)
						)
						(3
							(MuseumRgn sel_641:)
						)
						(4
							(MuseumRgn sel_642:)
						)
						(else
							(if (== (sel_42 sel_620:) gCurRoomNum)
								(MuseumRgn sel_643:)
							else
								0
							)
						)
					)
				)
				(switch sel_141
					(1
						(sel_42
							sel_654:
								(if temp2
									(temp2 sel_623:)
								else
									160
								)
							sel_655:
								(if temp2
									(temp2 sel_624:)
								else
									0
								)
						)
					)
					(2
						(sel_42
							sel_654:
								(if temp2
									(temp2 sel_627:)
								else
									320
								)
							sel_655:
								(if temp2
									(temp2 sel_628:)
								else
									95
								)
						)
					)
					(3
						(sel_42
							sel_654:
								(if temp2
									(temp2 sel_625:)
								else
									160
								)
							sel_655:
								(if temp2
									(temp2 sel_626:)
								else
									190
								)
						)
					)
					(4
						(sel_42
							sel_654:
								(if temp2
									(temp2 sel_629:)
								else
									0
								)
							sel_655:
								(if temp2
									(temp2 sel_630:)
								else
									95
								)
						)
					)
					(else
						(sel_42 sel_654: 0 sel_655: 0)
					)
				)
				(if (>= (= temp4 (sel_42 sel_654:)) 1000)
					(sel_42 sel_654: (- temp4 1000))
					(= sel_665 sel_141)
				)
				(= sel_136 1)
			)
			(3
				(if sel_666
					(= temp3 (sel_42 sel_620:))
				else
					(= temp3 (sel_42 sel_661: sel_141))
				)
				(cond
					(
						(and
							(== (sel_42 sel_620:) 530)
							(== temp3 600)
							(== gCurRoomNum 530)
						)
						(= sel_139 600)
					)
					(sel_666
						(= sel_136 1)
					)
					((> (MuseumRgn sel_644: temp3) 1)
						(if (not (= temp6 (sel_42 sel_533:)))
							(-- sel_29)
							(= sel_139 15)
						else
							(sel_42 sel_533: (-- temp6))
							(-- sel_29)
							(= sel_139 (* (Random 3 8) 60))
						)
					)
					((== (sel_42 sel_620:) gCurRoomNum)
						(= sel_139 60)
					)
					((not (sel_42 sel_649:))
						(= sel_139 (* (Random 3 15) 60))
					)
					(else
						(= sel_136 1)
					)
				)
			)
			(4
				(if sel_666
					(= sel_136 1)
				else
					(= temp2 (MuseumRgn sel_647: (sel_42 sel_620:)))
					(sel_42
						sel_312:
							PolyPath
							(sel_42 sel_654:)
							(sel_42 sel_655:)
							self
							1
							temp2
					)
				)
			)
			(5
				(if (and sel_665 (== (sel_42 sel_620:) gCurRoomNum))
					(self sel_146: (sUseDoor sel_109:) self 1)
				else
					(= sel_136 1)
				)
			)
			(6
				(= temp0 (* (sel_42 sel_653:) 5))
				(if sel_666
					(sel_42
						sel_2:
							(if (== (sel_42 sel_620:) gCurRoomNum)
								(sel_42 sel_648:)
							else
								828
							)
					)
					(= sel_666 0)
				else
					(= temp3 (sel_42 sel_661: sel_141))
					(sel_42
						sel_650: (sel_42 sel_620:)
						sel_620: temp3
						sel_2:
							(if (== temp3 gCurRoomNum)
								(sel_42 sel_648:)
							else
								828
							)
						sel_663:
					)
					(MuseumRgn
						sel_644: (sel_42 sel_620:) 1
						sel_644: (sel_42 sel_650:) -1
					)
				)
				(= temp8 sel_141)
				(= temp0 (* (sel_42 sel_653:) 6))
				(if (> (sel_42 sel_650:) 0)
					(= temp3 (sel_42 sel_650:))
					(for ((= sel_141 1)) (< sel_141 5) ((++ sel_141))
						(if (== [local100 (+ temp0 sel_141 1)] temp3)
							(break)
						)
					)
				else
					(= sel_141 -1)
				)
				(= temp9 sel_141)
				(= temp0 (* (sel_42 sel_653:) 11))
				(cond
					((== (sel_42 sel_620:) gCurRoomNum)
						(= temp2 (MuseumRgn sel_643:))
					)
					((sel_42 sel_660:)
						(= temp2
							(switch temp8
								(1
									(MuseumRgn sel_639:)
								)
								(2
									(MuseumRgn sel_640:)
								)
								(3
									(MuseumRgn sel_641:)
								)
								(4
									(MuseumRgn sel_642:)
								)
							)
						)
					)
					(else
						(= temp2 0)
					)
				)
				(switch temp9
					(1
						(if temp2
							(= temp4 (temp2 sel_623:))
							(= temp5 (temp2 sel_624:))
						else
							(= temp4 160)
							(= temp5 50)
						)
					)
					(2
						(if temp2
							(= temp4 (temp2 sel_627:))
							(= temp5 (temp2 sel_628:))
						else
							(= temp4 320)
							(= temp5 120)
						)
					)
					(3
						(if temp2
							(= temp4 (temp2 sel_625:))
							(= temp5 (temp2 sel_626:))
						else
							(= temp4 160)
							(= temp5 190)
						)
					)
					(4
						(if temp2
							(= temp4 (temp2 sel_629:))
							(= temp5 (temp2 sel_630:))
						else
							(= temp4 0)
							(= temp5 120)
						)
					)
					(-1
						(if temp2
							(= temp4 (temp2 sel_621:))
							(= temp5 (temp2 sel_622:))
						else
							(= temp4 160)
							(= temp5 165)
						)
					)
					(else
						(= temp4 (= temp5 0))
					)
				)
				(sel_42 sel_153: temp4 temp5)
				(if (>= temp4 1000)
					(-= temp4 1000)
					(= sel_665 sel_141)
				)
				(= sel_136 1)
			)
			(7
				(if (and sel_665 (== (sel_42 sel_620:) gCurRoomNum))
					(self sel_146: (sUseDoor sel_109:) self -1)
				else
					(= sel_136 1)
				)
			)
			(8
				(if (== (sel_42 sel_656:) -1)
					(cond
						(
							(and
								(== gCurRoomNum 510)
								(or
									(and
										(== (sel_42 sel_650:) 520)
										(< (sel_42 sel_652:) 510)
									)
									(and
										(== (sel_42 sel_650:) 500)
										(== (sel_42 sel_652:) 520)
									)
								)
							)
							(= temp4 80)
							(= temp5 165)
						)
						((> (MuseumRgn sel_644: (sel_42 sel_620:)) 1)
							(= temp4 (- ((MuseumRgn sel_643:) sel_621:) 15))
							(= temp5 (- ((MuseumRgn sel_643:) sel_622:) 15))
						)
						((== (sel_42 sel_620:) gCurRoomNum)
							(= temp4 ((MuseumRgn sel_643:) sel_621:))
							(= temp5 ((MuseumRgn sel_643:) sel_622:))
						)
						(else
							(= temp4 160)
							(= temp5 165)
						)
					)
				else
					(= temp4 (sel_42 sel_656:))
					(= temp5 (sel_42 sel_657:))
				)
				(= temp2 (MuseumRgn sel_647: (sel_42 sel_620:)))
				(sel_42 sel_312: PolyPath temp4 temp5 self 1 temp2)
			)
			(9
				(cond
					((!= (sel_42 sel_620:) (sel_42 sel_651:))
						(= sel_141 0)
						(self sel_144: 2)
					)
					((!= (sel_42 sel_652:) (sel_42 sel_651:))
						(cond
							(
								(==
									[local0
										(+ (* (= temp0 (sel_42 sel_663:)) 5) 1)
									]
									-1
								)
								(= sel_141 1)
								(sel_42
									sel_654: ((MuseumRgn sel_643:) sel_623:)
									sel_655: ((MuseumRgn sel_643:) sel_624:)
								)
							)
							((== [local0 (+ (* temp0 5) 2)] -1)
								(= sel_141 2)
								(sel_42
									sel_654: ((MuseumRgn sel_643:) sel_627:)
									sel_655: ((MuseumRgn sel_643:) sel_628:)
								)
							)
							((== [local0 (+ (* temp0 5) 3)] -1)
								(= sel_141 3)
								(sel_42
									sel_654: ((MuseumRgn sel_643:) sel_625:)
									sel_655: ((MuseumRgn sel_643:) sel_626:)
								)
							)
							((== [local0 (+ (* temp0 5) 4)] -1)
								(= sel_141 4)
								(sel_42
									sel_654: ((MuseumRgn sel_643:) sel_629:)
									sel_655: ((MuseumRgn sel_643:) sel_630:)
								)
							)
						)
						(= temp2 (MuseumRgn sel_647: (sel_42 sel_620:)))
						(sel_42
							sel_312:
								PolyPath
								(sel_42 sel_654:)
								(sel_42 sel_655:)
								self
								1
								temp2
						)
					)
					(else
						(sel_42 sel_649: 0)
						(self sel_111: 1)
					)
				)
			)
			(10
				(= temp3
					[local100 (+ (* (= temp0 (sel_42 sel_653:)) 6) sel_141 1)]
				)
				(sel_42
					sel_650: (sel_42 sel_620:)
					sel_620: temp3
					sel_651: (sel_42 sel_652:)
					sel_663:
				)
				(MuseumRgn
					sel_644: (sel_42 sel_620:) 1
					sel_644: (sel_42 sel_650:) -1
				)
				(= sel_666 1)
				(self sel_144: 1)
			)
		)
	)
)

(instance museumDialogueResume of Script
	(properties
		sel_20 {museumDialogueResume}
	)

	(method (sel_145 &tmp temp0 temp1)
		(= temp0 sel_42)
		(= sel_42 0)
		(if (IsObject temp0)
			(temp0 sel_667: 0)
			(if (IsObject (= temp1 (temp0 sel_142:)))
				(temp1 sel_144: (temp1 sel_29:))
			)
		)
	)
)

(instance sUseDoor of Script
	(properties
		sel_20 {sUseDoor}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(gUser sel_237: 0 sel_347: 0)
				(gGame sel_197: gWaitCursor)
				(if (== sel_141 -1)
					((sel_42 sel_42:)
						sel_63:
							(-
								((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_60:)
								1
							)
						sel_153:
							((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_597:)
							((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_598:)
					)
				)
				((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_161: End self)
				(global95
					sel_81: ((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_603:)
				)
			)
			(1
				(= temp0
					(if (== sel_141 1)
						((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_597:)
					else
						((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_303:)
					)
				)
				(= temp1
					(if (== sel_141 1)
						((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_598:)
					else
						((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_304:)
					)
				)
				((sel_42 sel_42:) sel_63: -1 sel_312: PolyPath temp0 temp1 self)
			)
			(2
				((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_161: Beg)
				(global95
					sel_118: ((ScriptID gCurRoomNum (sel_42 sel_665:)) sel_603:)
				)
				(sel_42 sel_665: 0)
				(gGame sel_197: ((gTheIconBar sel_207:) sel_33:))
				(gUser sel_237: 1 sel_347: 1)
				(self sel_111:)
			)
		)
	)
)

(instance fumeTimer of Timer
	(properties
		sel_20 {fumeTimer}
	)

	(method (sel_162)
		(MuseumRgn sel_135: self)
		(super sel_162: &rest)
	)

	(method (sel_145)
		(ClearFlag 20)
	)
)

(instance meetingTimer of Timer
	(properties
		sel_20 {meetingTimer}
	)

	(method (sel_162 param1 param2 param3 param4 param5)
		(= gClockTimeMustDos param5)
		(MuseumRgn sel_135: self)
		(super sel_162: param1 param2 param3 param4)
	)

	(method (sel_145)
		(gCurRoom sel_403:)
		((ScriptID 22 0) sel_57: gClockTimeMustDos) ; triggerAndClock
	)
)

(instance wanderTimer of Timer
	(properties
		sel_20 {wanderTimer}
	)

	(method (sel_145 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (gCast sel_86:)) ((++ temp0))
			(if
				(and
					((= temp1 (gCast sel_64: temp0)) sel_116: 620)
					(== (temp1 sel_620:) -1)
				)
				(temp1 sel_664:)
			)
		)
		(self sel_162: self 120)
	)
)
